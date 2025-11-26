package com.example.fitjourney.mapper;

import org.springframework.stereotype.Component;

import com.example.fitjourney.dto.request.UserCreateRequestDTO;
import com.example.fitjourney.dto.response.UserResponseDTO;
import com.example.fitjourney.entity.User;

@Component
public class UserMapper {

	public static User toEntity(UserCreateRequestDTO request) {
		if (request == null)
			return null;

		User user = new User();

		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPasswor());
		user.setEnabled(true);

		return user;
	}

	public UserResponseDTO toDto(User u) {
		if (u == null)
			return null;
		
		UserResponseDTO d = new UserResponseDTO();
		
		d.setUserId(u.getUserId());
		d.setUsername(u.getUsername());
		d.setEmail(u.getEmail());
		d.setEnabled(u.isEnabled());
		
		return d;
	}

}
