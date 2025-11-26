package com.example.fitjourney.mapper;

import org.springframework.stereotype.Component;
import com.example.fitjourney.dto.request.FoodRequestDTO;
import com.example.fitjourney.dto.response.FoodResponseDTO;
import com.example.fitjourney.entity.Food;

@Component
public class FoodMapper {

	public Food toEntity(FoodRequestDTO dto) {
		if (dto == null)
			return null;

		Food f = new Food();

		f.setFoodName(dto.getFoodName());
		f.setCalories(dto.getCalories());
		f.setProtein(dto.getProtein());
		f.setCarbs(dto.getCarbs());
		f.setFats(dto.getFats());

		return f;
	}

	public FoodResponseDTO toDto(Food f) {

		if (f == null)
			return null;

		FoodResponseDTO r = new FoodResponseDTO();

		r.setFoodId(f.getFoodId());
		r.setFoodName(f.getFoodName());
		r.setCalories(f.getCalories());
		r.setProtein(f.getProtein());
		r.setCarbs(f.getCarbs());
		r.setFats(f.getFats());

		return r;
	}
}
