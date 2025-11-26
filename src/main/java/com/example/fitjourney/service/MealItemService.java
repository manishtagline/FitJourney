package com.example.fitjourney.service;

import java.util.List;

import com.example.fitjourney.dto.request.MealItemRequestDTO;
import com.example.fitjourney.dto.response.MealItemResponseDTO;

public interface MealItemService {

	MealItemResponseDTO create(MealItemRequestDTO dto);

	MealItemResponseDTO getById(Long id);

	List<MealItemResponseDTO> getByMeal(Long mealId);

	void delete(Long id);

}
