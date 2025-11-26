package com.example.fitjourney.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fitjourney.dto.request.UserCreateRequestDTO;
import com.example.fitjourney.dto.response.UserResponseDTO;
import com.example.fitjourney.entity.User;
import com.example.fitjourney.exception.ResourceNotFoundException;
import com.example.fitjourney.mapper.UserMapper;
import com.example.fitjourney.repository.UserRepository;
import com.example.fitjourney.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	private UserMapper userMapper;

	@Override
	public UserResponseDTO createUser(UserCreateRequestDTO request) {
		log.info("Creating a user with email:{}",request.getEmail());
		
		User user = userMapper.toEntity(request);
		User savedUser = userRepository.save(user);
		
		log.info("User created with Id:{}",savedUser.getUserId());
		
		return userMapper.toDto(savedUser);
	}

	@Override
	public UserResponseDTO getUserById(Long userId) {
		log.info("Fetching user of Id:{}"+userId);
		
		User user = userRepository.findById(userId)
				.orElseThrow(() -> {
				log.error("User not found of Id:{}",userId);
				return new ResourceNotFoundException("User not found!!!");
				});
		
		log.debug("User found: {}", user.getEmail());
		
		return userMapper.toDto(user);
	}

	@Override
	public List<UserResponseDTO> getAllUser() {
		log.info("Fetching all users.");
		
		List<UserResponseDTO> users = userRepository.findAll()
				.stream()
				.map(userMapper::toDto)
				.collect(Collectors.toList());
		
		log.debug("Total users found: {}", users.size());
		
		return users;
	}

	@Override
	public void deleteUser(Long userId) {
		log.info("Deleting request of user for Id:{}",userId);
		

        if (!userRepository.existsById(userId)) {
            log.warn("Cannot delete. User not found for ID: {}", userId);
            throw new ResourceNotFoundException("User not found");
        }

        userRepository.deleteById(userId);
        log.info("User deleted successfully. ID: {}", userId);
		
	}

}
