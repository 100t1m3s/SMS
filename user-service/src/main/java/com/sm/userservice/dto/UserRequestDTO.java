package com.sm.userservice.dto;

import com.sm.userservice.dto.validators.CreateUserValidationGrop;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {


    @NotBlank(message = "Name is required")
    @Size(max=100, message = "Name can not exceed 100 characters")
    private String name;


    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;


    @NotBlank(message = "Address is required")
    private String address;


    @NotBlank(message = "Date of Birth is required")
    private String dateOfBirth;


    @NotBlank(groups = CreateUserValidationGrop.class,message = "Registerd date is required")
    private String registerdDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisterdDate() {
        return registerdDate;
    }

    public void setRegisterdDate(String registerdDate) {
        this.registerdDate = registerdDate;
    }
}
