package com.example.fitjourney.service;

import java.util.List;

import com.example.fitjourney.dto.request.ExerciseRequestDTO;
import com.example.fitjourney.dto.response.ExerciseResponseDTO;

public interface ExerciseService {

	ExerciseResponseDTO create(ExerciseRequestDTO dto);

	ExerciseResponseDTO getById(Long id);

	List<ExerciseResponseDTO> getByWorkout(Long workoutId);

	void delete(Long id);

}
