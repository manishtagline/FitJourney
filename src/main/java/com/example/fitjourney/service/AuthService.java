package com.example.fitjourney.service;

import com.example.fitjourney.dto.request.LoginRequest;
import com.example.fitjourney.dto.request.RegisterRequest;
import com.example.fitjourney.dto.response.AuthResponse;

public interface AuthService {

	String registerUser(RegisterRequest request);
	AuthResponse loginUser(LoginRequest request);
	String logoutUser(String token);

}
