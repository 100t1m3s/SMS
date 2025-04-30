package com.sm.authservice.service;

import com.sm.authservice.dto.LoginRequestDTO;
import com.sm.authservice.model.User;
import com.sm.authservice.repository.UserRepository;
import com.sm.authservice.utill.JwtUtill;
import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtill jwtUtill;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtill jwtUtill) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtill = jwtUtill;
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<String> token = userService.findByEmail(loginRequestDTO.getEmail())
                .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword()))
                .map(u -> jwtUtill.generateToken(u.getEmail(), u.getRole()));

        return token;
    }

    public boolean validateToken(String token) {
        try {
            jwtUtill.validateToken(token);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


}
