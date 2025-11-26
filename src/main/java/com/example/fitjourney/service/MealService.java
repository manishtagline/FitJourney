package com.example.fitjourney.service;

import java.util.List;

import com.example.fitjourney.dto.request.MealRequestDTO;
import com.example.fitjourney.dto.response.MealResponseDTO;

public interface MealService {

	MealResponseDTO create(MealRequestDTO dto);

	MealResponseDTO getById(Long id);

	List<MealResponseDTO> getByGoal(Long goalId);

	List<MealResponseDTO> getByProfileAndType(Long profileId, String mealType);

	void delete(Long id);

}
