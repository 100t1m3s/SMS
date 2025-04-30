package com.sm.userservice.mapper;

import com.sm.userservice.dto.UserRequestDTO;
import com.sm.userservice.dto.UserResponseDTO;
import com.sm.userservice.model.User;

import java.time.LocalDate;

public class UserMapper {

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(user.getId().toString());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setDateOfBirth(user.getDateOfBirth().toString());

        return userDTO;
    }

    public static User toModel(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setAddress(userRequestDTO.getAddress());
        user.setDateOfBirth(LocalDate.parse(userRequestDTO.getDateOfBirth()));
        user.setRegisteredDate(LocalDate.parse(userRequestDTO.getRegisterdDate()));

        return user;
    }
}
