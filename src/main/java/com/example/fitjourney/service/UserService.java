package com.example.fitjourney.service;

import java.util.List;

import com.example.fitjourney.dto.request.UserCreateRequestDTO;
import com.example.fitjourney.dto.response.UserResponseDTO;

public interface UserService {

	UserResponseDTO createUser(UserCreateRequestDTO request);
	
	UserResponseDTO getUserById(Long userId);
	
	List<UserResponseDTO> getAllUser();
	
	void deleteUser(Long userId);
	
}
