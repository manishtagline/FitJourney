package com.example.fitjourney.dto.response;

import lombok.Data;

@Data
public class FoodResponseDTO {

    private Long foodId;
    
    private String foodName;
    
    private Double calories;
    
    private Double protein;
    
    private Double carbs;
    
    private Double fats;
	
}
