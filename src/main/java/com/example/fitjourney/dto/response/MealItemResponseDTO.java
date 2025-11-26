package com.example.fitjourney.dto.response;

import lombok.Data;

@Data
public class MealItemResponseDTO {

    private Long mealItemId;
    
    private Double quantity;
    
    private Long foodId;
    
    private String foodName;
	
}
