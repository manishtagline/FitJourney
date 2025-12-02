package com.example.fitjourney.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fitjourney.dto.request.WorkoutRequestDTO;
import com.example.fitjourney.dto.response.WorkoutResponseDTO;
import com.example.fitjourney.mapper.WorkoutMapper;
import com.example.fitjourney.repository.GoalRepository;
import com.example.fitjourney.repository.WorkoutRepository;
import com.example.fitjourney.service.WorkoutService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class WorkoutServiceImpl implements WorkoutService{
	

    private final WorkoutRepository workoutRepo;
    
    private final GoalRepository goalRepo;
    
    private final WorkoutMapper workoutMapper;

	
	@Override
	public WorkoutResponseDTO create(WorkoutRequestDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkoutResponseDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkoutResponseDTO> getByGoal(Long goalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkoutResponseDTO> getByProfileBetween(Long profileId, LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
