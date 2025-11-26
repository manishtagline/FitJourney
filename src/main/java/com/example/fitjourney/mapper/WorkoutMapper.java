package com.example.fitjourney.mapper;

import org.springframework.stereotype.Component;

import com.example.fitjourney.dto.request.WorkoutRequestDTO;
import com.example.fitjourney.dto.response.WorkoutResponseDTO;
import com.example.fitjourney.entity.Goal;
import com.example.fitjourney.entity.Workout;

@Component
public class WorkoutMapper {

	public static Workout toEntity(WorkoutRequestDTO request, Goal goal) {
		if(request == null)
			return null;
		
		Workout workout = new Workout();
		
		workout.setWorkoutName(request.getWorkoutName());
		workout.setWorkoutDate(request.getWorkoutDate());
		workout.setCaloriesBurned(request.getCaloriesBurned());
		workout.setDuration(request.getDuration());
		workout.setGoal(goal);
		
		return workout;
	}
	
	public static WorkoutResponseDTO toDto(Workout w) {
		if(w == null)
			return null;
		
		WorkoutResponseDTO response = new WorkoutResponseDTO();
		
		response.setWorkoutId(w.getWorkoutId());
		response.setWorkoutName(w.getWorkoutName());
		response.setWorkoutDate(w.getWorkoutDate());
		response.setCaloriesBurned(w.getCaloriesBurned());
		response.setDuration(w.getDuration());
		if(w.getGoal() != null) response.setGoalId(w.getGoal().getGoalId());
		
		return response;
		
	}
	
}
