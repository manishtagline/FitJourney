package com.example.fitjourney.dto.response;

import java.time.LocalDate;

import com.example.fitjourney.entity.enums.GoalType;

import lombok.Data;

@Data
public class GoalResponseDTO {

    private Long goalId;
    
    private GoalType goalType;
    
    private Double targetValue;
    
    private Double currentValue;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private Long profileId;
	
}
