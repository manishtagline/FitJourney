package com.example.fitjourney.service;

import java.time.LocalDate;
import java.util.List;

import com.example.fitjourney.dto.request.WorkoutRequestDTO;
import com.example.fitjourney.dto.response.WorkoutResponseDTO;

public interface WorkoutService {

	WorkoutResponseDTO create(WorkoutRequestDTO dto);

	WorkoutResponseDTO getById(Long id);

	List<WorkoutResponseDTO> getByGoal(Long goalId);

	List<WorkoutResponseDTO> getByProfileBetween(Long profileId, LocalDate from, LocalDate to);

	void delete(Long id);

}
