package com.example.fitjourney.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fitjourney.service.GoalService;
import com.example.fitjourney.repository.GoalRepository;
import com.example.fitjourney.repository.ProfileRepository;
import com.example.fitjourney.mapper.GoalMapper;
import com.example.fitjourney.dto.request.GoalRequestDTO;
import com.example.fitjourney.dto.response.GoalResponseDTO;
import com.example.fitjourney.entity.Goal;
import com.example.fitjourney.entity.Profile;
import com.example.fitjourney.exception.ResourceNotFoundException;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class GoalServiceImpl implements GoalService{


    private final GoalRepository goalRepo;
    private final ProfileRepository profileRepo;
    private final GoalMapper goalMapper;

    @Override
    public GoalResponseDTO createGoal(GoalRequestDTO dto) {
        log.info("Creating goal for profileId: {}", dto.getProfileId());

        Profile profile = profileRepo.findById(dto.getProfileId())
                .orElseThrow(() -> {
                    log.warn("Profile not found for profileId: {}", dto.getProfileId());
                    return new ResourceNotFoundException("Profile not found");
                });

        Goal goal = goalMapper.toEntity(dto, profile);
        Goal saved = goalRepo.save(goal);

        log.debug("Goal created with goalId: {}", saved.getGoalId());
        return goalMapper.toDto(saved);
    }

    @Override
    public GoalResponseDTO getById(Long id) {
        log.info("Fetching goal by goalId: {}", id);

        Goal goal = goalRepo.findById(id)
                .orElseThrow(() -> {
                    log.warn("Goal not found for goalId: {}", id);
                    return new ResourceNotFoundException("Goal not found");
                });

        log.debug("Goal found: goalId = {}", goal.getGoalId());
        return goalMapper.toDto(goal);
    }

    @Override
    public List<GoalResponseDTO> getByProfile(Long profileId) {
        log.info("Fetching goals for profileId: {}", profileId);

        List<GoalResponseDTO> goals = goalRepo.findByProfileProfileId(profileId)
                .stream()
                .map(goalMapper::toDto)
                .collect(Collectors.toList());

        log.debug("Total goals found for profileId {}: {}", profileId, goals.size());
        return goals;
    }

    @Override
    public List<GoalResponseDTO> getActiveByProfile(Long profileId) {
        log.info("Fetching active goals for profileId: {}", profileId);

        List<GoalResponseDTO> activeGoals = goalRepo.findActiveGoalsByProfileId(profileId)
                .stream()
                .map(goalMapper::toDto)
                .collect(Collectors.toList());

        log.debug("Total active goals for profileId {}: {}", profileId, activeGoals.size());
        return activeGoals;
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting goal with goalId: {}", id);

        if (!goalRepo.existsById(id)) {
            log.warn("Cannot delete. Goal not found for goalId: {}", id);
            throw new ResourceNotFoundException("Goal not found");
        }

        goalRepo.deleteById(id);
        log.info("Goal deleted successfully. goalId: {}", id);
    }
	
}
