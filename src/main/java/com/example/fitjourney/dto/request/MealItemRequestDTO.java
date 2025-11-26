package com.example.fitjourney.dto.request;

import lombok.Data;

@Data
public class MealItemRequestDTO {

    private Long mealId;
    
    private Long foodId;
    
    private Double quantity;
	
}
