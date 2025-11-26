package com.example.fitjourney.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitjourney.dto.request.LoginRequest;
import com.example.fitjourney.dto.request.RegisterRequest;
import com.example.fitjourney.dto.response.AuthResponse;
import com.example.fitjourney.service.AuthService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "User Management", description = "Registarion & Login user")
public class AuthController {

	private final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
		log.info("Recevied registration request for email: {}", request.getEmail());
		
		try {
			String response = authService.registerUser(request);
			log.info("Registration response for email {}: {}", request.getEmail(), response);
			
			return ResponseEntity.ok().body(response);
			
		} catch (IllegalArgumentException e) {
			log.error("Registration faile for email {}: {}", request.getEmail(), e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
			
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest request){
		log.info("Login attempt for email: {}", request.getEmail());
	    try {
	         AuthResponse response = authService.loginUser(request);
	         log.info("Login successfull for email: {}", request.getEmail());
	            
	         return ResponseEntity.ok(response);
	            
	    } catch (Exception e) { 
	        log.error("Error: {}"+e.getClass().toString());
	         log.warn("Login failed for email {}: {}", request.getEmail(), e.getMessage());
	         return ResponseEntity.status(401).body("Invalid email or password");
	    }
	
	}
	
}
