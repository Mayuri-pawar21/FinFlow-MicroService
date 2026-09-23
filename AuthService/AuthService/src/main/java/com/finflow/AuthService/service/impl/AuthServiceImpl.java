package com.finflow.AuthService.service.impl;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.finflow.AuthService.dto.request.LoginRequest;
import com.finflow.AuthService.dto.request.RegisterRequest;
import com.finflow.AuthService.dto.response.AuthResponse;
import com.finflow.AuthService.entity.User;
import com.finflow.AuthService.enums.Role;
import com.finflow.AuthService.repository.UserRepository;
import com.finflow.AuthService.security.JwtService;
import com.finflow.AuthService.service.AuthService;

@Service
public class AuthServiceImpl  implements AuthService{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

   

   

	public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	@Override
    public AuthResponse register(RegisterRequest request) {

		if (userRepository.existsByEmail(request.getEmail())) {
	        throw new RuntimeException("Email already exists");
	    }

	    User user = new User();

	    user.setFirstName(request.getFirstName());
	    user.setLastName(request.getLastName());
	    user.setEmail(request.getEmail());

	    // Encrypt the password
	    user.setPassword(passwordEncoder.encode(request.getPassword()));

	    user.setRole(Role.USER);
	    user.setEnabled(true);
	    user.setCreatedAt(LocalDateTime.now());

	    userRepository.save(user);

	    String token = jwtService.generateToken(user);	

	    return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

    	 User user = userRepository.findByEmail(request.getEmail())
    	            .orElseThrow(() -> new RuntimeException("User not found"));

    	    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
    	        throw new RuntimeException("Invalid password");
    	    }

    	    String token = jwtService.generateToken(user);

    	    return new AuthResponse(token);
    }
}
