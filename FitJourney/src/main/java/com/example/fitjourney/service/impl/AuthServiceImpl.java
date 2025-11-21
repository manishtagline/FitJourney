package com.example.fitjourney.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fitjourney.dto.request.LoginRequest;
import com.example.fitjourney.dto.request.RegisterRequest;
import com.example.fitjourney.dto.response.AuthResponse;
import com.example.fitjourney.entity.User;
import com.example.fitjourney.repository.UserRepository;
import com.example.fitjourney.security.JwtTokenProvider;
import com.example.fitjourney.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService{

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authManager;
	
	private final JwtTokenProvider tokenProvider;
	
	@Override
	public String registerUser(RegisterRequest request) {
		log.info("Attempting to register user with email: {}", request.getEmail());
		
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			log.warn("Registeration failed email '{}' is already regsired!!!", request.getEmail());
			throw new IllegalArgumentException("Email already exists!!!");
		}
		
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		userRepository.save(user);
		
		log.info("User registered successfully: {}", request.getEmail());
	    return "User registered successfully!";
	}

	@Override
	public AuthResponse loginUser(LoginRequest request) {
		log.info("Login attempt for email : {}", request.getEmail());
		
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
					);	
			
			log.info("Authentication is successfull for email: {}", request.getEmail());
			
			String token = tokenProvider.generateToken(authentication);
			log.info("JWT token is generated for email: {}", request.getEmail());
			
			AuthResponse response = new AuthResponse();
			response.setToken(token);
			response.setMessage("Login Successfully...");
			
			return response;
			
		} catch (AuthenticationException ex) {
			 log.error("Authentication failed for email: {} - {}", request.getEmail(), ex.getMessage());
		        // Throw exception so client gets 401
		        throw new RuntimeException("Invalid email or password"); 
		
		}catch (IllegalArgumentException e) {
			log.error("Error:",e);
			 throw new RuntimeException("Invalid email or password"); 
		}
		
		
	}

	@Override
	public String logoutUser(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
