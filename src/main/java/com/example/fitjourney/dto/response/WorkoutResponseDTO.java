package com.example.fitjourney.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class WorkoutResponseDTO {

    private Long workoutId;
    
    private String workoutName;
    
    private LocalDate workoutDate;
    
    private Double caloriesBurned;
    
    private String duration;
    
    private Long goalId;
	
}
