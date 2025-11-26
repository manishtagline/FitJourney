package com.example.fitjourney.dto.request;

import lombok.Data;

@Data
public class FoodRequestDTO {

    private String foodName;
    
    private Double calories;
    
    private Double protein;
    
    private Double carbs;
    
    private Double fats;
	
}
