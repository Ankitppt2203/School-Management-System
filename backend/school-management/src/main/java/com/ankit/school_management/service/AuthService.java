package com.ankit.school_management.service;

import com.ankit.school_management.DTO.LoginRequest;
import com.ankit.school_management.DTO.LoginResponse;
import com.ankit.school_management.entity.User;
import com.ankit.school_management.repository.UserRepository;
import com.ankit.school_management.security.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

        private final UserRepository userRepository;
        private final JwtService jwtService;

        public AuthService(
                        UserRepository userRepository,
                        JwtService jwtService) {

                this.userRepository = userRepository;
                this.jwtService = jwtService;
        }

        public LoginResponse login(
                        LoginRequest request) {

                User user = userRepository.findByUsername(
                                request.getUsername())
                                .orElseThrow(() -> new RuntimeException(
                                                "User not found"));

                if (!user.getPassword()
                                .equals(request.getPassword())) {

                        throw new RuntimeException(
                                        "Invalid password");
                }

                String token = jwtService.generateToken(
                                user.getUsername(),
                                user.getRole().name());

                long expiresIn = jwtService.getExpirationTimeInSeconds();

                return new LoginResponse(
                                token,
                                expiresIn,
                                "Bearer");
        }
}