package com.finflow.AuthService.service;

import com.finflow.AuthService.dto.request.LoginRequest;
import com.finflow.AuthService.dto.request.RegisterRequest;
import com.finflow.AuthService.dto.response.AuthResponse;

public interface AuthService {

	AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
