package com.example.fitjourney.dto.response;

import com.example.fitjourney.entity.enums.DifficultyLevel;

import lombok.Data;

@Data
public class ProfileResponseDTO {

	private Long profileId;
	
	private Long userId;
	
	private Double height;
	
	private Double weight;
	
	private Double bmi;
	
	private int age;
	
	private DifficultyLevel fitnessLevel;
	
}
