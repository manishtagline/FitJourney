package com.example.fitjourney.dto.request;

import com.example.fitjourney.entity.enums.DifficultyLevel;

import lombok.Data;

@Data
public class ProfileRequestDTO {

	private Long userId;
	
	private int age;
	
	private Double height;
	
	private Double weight;
	
	private DifficultyLevel fitnessLevel;
	
}
