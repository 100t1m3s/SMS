package com.sm.userservice.controller;

import com.sm.userservice.dto.UserRequestDTO;
import com.sm.userservice.dto.UserResponseDTO;
import com.sm.userservice.dto.validators.CreateUserValidationGrop;
import com.sm.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "API for managing Users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    @Operation(summary = "Get Users")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<UserResponseDTO> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }


    @PostMapping
    @Operation(summary = "Create User")
    public ResponseEntity<UserResponseDTO> createUser(@Validated({Default.class, CreateUserValidationGrop.class}) @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update User")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable UUID id , @Validated({Default.class}) @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.updateUser(id, userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
