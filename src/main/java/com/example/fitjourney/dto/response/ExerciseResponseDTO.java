package com.example.fitjourney.dto.response;

import com.example.fitjourney.entity.enums.DifficultyLevel;

import lombok.Data;

@Data
public class ExerciseResponseDTO {

    private Long exerciseId;
    
    private String exerciseName;
    
    private int sets;
    
    private int reps;
    
    private Double weightUsed;
    
    private DifficultyLevel diffcultyLevel;
    
    private Long workoutId;
	
}
