package com.example.fitjourney.mapper;

import org.springframework.stereotype.Component;

import com.example.fitjourney.dto.request.GoalRequestDTO;
import com.example.fitjourney.dto.response.GoalResponseDTO;
import com.example.fitjourney.entity.Goal;
import com.example.fitjourney.entity.Profile;

@Component
public class GoalMapper {

	public static Goal toEntity(GoalRequestDTO request, Profile profile) {
		if(request == null) 
			return null;
		
		Goal goal = new Goal();
		
		goal.setGoalType(request.getGoalType());
		goal.setCurrentValue(request.getCurrentValue());
		goal.setTargetValue(request.getTargetValue());
		goal.setStartDate(request.getStartDate());
		goal.setEndDate(request.getEndDate());
		goal.setProfile(profile);
		
		return goal;
		
	}
	
	public  GoalResponseDTO toDto(Goal g) {
		if(g == null)
			return null;
		
		GoalResponseDTO response = new GoalResponseDTO();
		
		response.setGoalId(g.getGoalId());
		response.setCurrentValue(g.getCurrentValue());
		response.setTargetValue(g.getTargetValue());
		response.setStartDate(g.getStartDate());
		response.setEndDate(g.getEndDate());
		response.setGoalType(g.getGoalType());
		if(g.getProfile() != null) response.setProfileId(g.getProfile().getProfileId());
		
		return response;
		
	}
	
}
