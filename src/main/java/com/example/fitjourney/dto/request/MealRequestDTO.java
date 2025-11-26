package com.example.fitjourney.dto.request;

import com.example.fitjourney.entity.enums.MealType;

import lombok.Data;

@Data
public class MealRequestDTO {

    private Long goalId;
    
    private MealType mealType;
    
    private Double protein;
    
    private Double carbs;
    
    private Double fats;
    
    private Double totalCalories;
	
}
