package com.example.fitjourney.dto.response;

import lombok.Data;

@Data
public class UserResponseDTO {

	private Long userId;
	
	private String username;
	
	private String email;
	
	private boolean enabled;
	
}
