package com.sm.userservice.service;

import com.sm.userservice.dto.UserRequestDTO;
import com.sm.userservice.dto.UserResponseDTO;
import com.sm.userservice.exception.UserNotFoundException;
import com.sm.userservice.grpc.BillingServiceGrpcClient;
import com.sm.userservice.kafka.KafkaProducer;
import com.sm.userservice.mapper.UserMapper;
import com.sm.userservice.model.User;
import com.sm.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.sm.userservice.exception.EmailAlreadyExistsException;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingServiceGrpcClient billingServiceGrpcClient;
    private final KafkaProducer kafkaProducer;

    public UserService(UserRepository userRepository, BillingServiceGrpcClient billingServiceGrpcClient, KafkaProducer kafkaProducer) {
        this.userRepository = userRepository;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
    }

    public List<UserResponseDTO> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper::toDTO).toList();
    }


    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        if(userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A user with this email " + "already exists " + userRequestDTO.getEmail());
        }

        User newUser = userRepository.save(UserMapper.toModel(userRequestDTO));

        billingServiceGrpcClient.createBillingAccount(newUser.getId().toString(), newUser.getName(), newUser.getEmail());

        kafkaProducer.sendEvent(newUser);

        return UserMapper.toDTO(newUser);
    }


    public UserResponseDTO updateUser(UUID id , UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID:" + id));

        if (userRepository.existsByEmailAndIdNot(userRequestDTO.getEmail(),id)) {
            throw new UserNotFoundException("A user with this email " + "already exists " + userRequestDTO.getEmail());
        }

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setAddress(userRequestDTO.getAddress());
        user.setDateOfBirth(LocalDate.parse(userRequestDTO.getDateOfBirth()));

        User updatedUser = userRepository.save(user);

        return UserMapper.toDTO(updatedUser);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }


}
