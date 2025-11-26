package com.example.fitjourney.service;

import java.util.List;

import com.example.fitjourney.dto.request.FoodRequestDTO;
import com.example.fitjourney.dto.response.FoodResponseDTO;

public interface FoodService {

	FoodResponseDTO create(FoodRequestDTO dto);

	FoodResponseDTO getById(Long id);

	List<FoodResponseDTO> getAll();

	void delete(Long id);

}
