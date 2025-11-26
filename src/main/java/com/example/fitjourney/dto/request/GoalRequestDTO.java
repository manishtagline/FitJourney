package com.example.fitjourney.dto.request;

import java.time.LocalDate;

import com.example.fitjourney.entity.enums.GoalType;

import lombok.Data;

@Data
public class GoalRequestDTO {

    private GoalType goalType;
    
    private Double targetValue;
    
    private Double currentValue;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private Long profileId;
	
}
