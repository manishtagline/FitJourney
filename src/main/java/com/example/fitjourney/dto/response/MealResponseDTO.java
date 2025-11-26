package com.example.fitjourney.dto.response;

import java.util.List;

import com.example.fitjourney.entity.enums.MealType;

import lombok.Data;

@Data
public class MealResponseDTO {

    private Long mealId;
    
    private MealType mealType;
    
    private Double protein;
    
    private Double carbs;
    
    private Double fats;
    
    private Double totalCalories;
    
    private Long goalId;
    
    private List<MealItemResponseDTO> mealItems;
	
}
