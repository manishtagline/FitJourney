package com.example.fitjourney.service;

import java.util.List;

import com.example.fitjourney.dto.request.GoalRequestDTO;
import com.example.fitjourney.dto.response.GoalResponseDTO;

public interface GoalService {

	GoalResponseDTO createGoal(GoalRequestDTO dto);

	GoalResponseDTO getById(Long id);

	List<GoalResponseDTO> getByProfile(Long profileId);

	List<GoalResponseDTO> getActiveByProfile(Long profileId);

	void delete(Long id);

}
