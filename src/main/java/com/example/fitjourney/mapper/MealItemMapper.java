package com.example.fitjourney.mapper;

import org.springframework.stereotype.Component;
import com.example.fitjourney.dto.request.MealItemRequestDTO;
import com.example.fitjourney.dto.response.MealItemResponseDTO;
import com.example.fitjourney.entity.MealItem;
import com.example.fitjourney.entity.Meal;
import com.example.fitjourney.entity.Food;

@Component
public class MealItemMapper {

	public MealItem toEntity(MealItemRequestDTO dto, Meal meal, Food food) {
		if (dto == null)
			return null;

		MealItem mi = new MealItem();
		mi.setQuantity(dto.getQuantity());
		mi.setMeal(meal);
		mi.setFood(food);

		return mi;

	}

	public MealItemResponseDTO toDto(MealItem mi) {

		if (mi == null)
			return null;

		MealItemResponseDTO r = new MealItemResponseDTO();
		r.setMealItemId(mi.getMealItemId());
		r.setQuantity(mi.getQuantity());
		if (mi.getFood() != null) {
			r.setFoodId(mi.getFood().getFoodId());
			r.setFoodName(mi.getFood().getFoodName());
		}

		return r;
	}
}