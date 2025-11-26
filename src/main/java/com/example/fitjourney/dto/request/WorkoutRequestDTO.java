package com.example.fitjourney.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class WorkoutRequestDTO {

    private Long goalId;
    
    private String workoutName;
    
    private LocalDate workoutDate;
    
    private Double caloriesBurned;
    
    private String duration;
    
}
	

