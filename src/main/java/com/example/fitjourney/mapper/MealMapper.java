package com.example.fitjourney.mapper;

import org.springframework.stereotype.Component;
import com.example.fitjourney.dto.request.MealRequestDTO;
import com.example.fitjourney.dto.response.MealResponseDTO;
import com.example.fitjourney.entity.Meal;
import com.example.fitjourney.entity.Goal;
import java.util.stream.Collectors;

@Component
public class MealMapper {
	
	public Meal toEntity(MealRequestDTO dto, Goal goal) {
		if (dto == null)
			return null;
		
		Meal m = new Meal();
		m.setProtein(dto.getProtein());
		m.setCarbs(dto.getCarbs());
		m.setFats(dto.getFats());
		m.setTotalCalories(dto.getTotalCalories());
		m.setMealType(dto.getMealType());
		m.setGoal(goal);
		
		return m;
	}

	public MealResponseDTO toDto(Meal m) {
		if (m == null)
			return null;
		
		MealResponseDTO r = new MealResponseDTO();
		r.setMealId(m.getMealId());
		r.setMealType(m.getMealType());
		r.setProtein(m.getProtein());
		r.setCarbs(m.getCarbs());
		r.setFats(m.getFats());
		r.setTotalCalories(m.getTotalCalories());
		if (m.getGoal() != null)
			r.setGoalId(m.getGoal().getGoalId());
		if (m.getMealItems() != null)
			r.setMealItems(m.getMealItems().stream()
					.map(MealItem -> new com.example.fitjourney.dto.response.MealItemResponseDTO() {
						{
							setMealItemId(MealItem.getMealItemId());
							setQuantity(MealItem.getQuantity());
							setFoodId(MealItem.getFood() != null ? MealItem.getFood().getFoodId() : null);
							setFoodName(MealItem.getFood() != null ? MealItem.getFood().getFoodName() : null);
						}
					}).collect(Collectors.toList()));
		
		return r;
	}
}