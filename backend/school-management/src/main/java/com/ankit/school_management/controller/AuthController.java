package com.ankit.school_management.controller;

import com.ankit.school_management.DTO.ErrorResponse;
import com.ankit.school_management.DTO.LoginRequest;
import com.ankit.school_management.DTO.LoginResponse;
import com.ankit.school_management.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService) {

        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        try {

            LoginResponse response = authService.login(request);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {

            ErrorResponse error = new ErrorResponse(
                    e.getMessage(),
                    401);

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(error);

        } catch (Exception e) {

            ErrorResponse error = new ErrorResponse(
                    "Internal server error",
                    500);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error);
        }
    }
}