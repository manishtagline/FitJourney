package com.example.fitjourney.dto.request;

import com.example.fitjourney.entity.enums.DifficultyLevel;

import lombok.Data;

@Data
public class ExerciseRequestDTO {

    private Long workoutId;
    
    private String exerciseName;
    
    private int sets;
    
    private int reps;
    
    private Double weightUsed;
    
    private DifficultyLevel diffcultyLevel;
	
}
