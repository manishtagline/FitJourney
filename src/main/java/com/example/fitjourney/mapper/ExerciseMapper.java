package com.example.fitjourney.mapper;

import org.springframework.stereotype.Component;

import com.example.fitjourney.dto.request.ExerciseRequestDTO;
import com.example.fitjourney.dto.response.ExerciseResponseDTO;
import com.example.fitjourney.entity.Exercise;
import com.example.fitjourney.entity.Workout;

@Component
public class ExerciseMapper {

	public static Exercise toEntity(ExerciseRequestDTO request, Workout workout) {
		if (request == null)
			return null;
		Exercise e = new Exercise();
		e.setExerciseName(request.getExerciseName());
		e.setSets(request.getSets());
		e.setReps(request.getReps());
		e.setWeightUsed(request.getWeightUsed());
		e.setDiffcultyLevel(request.getDiffcultyLevel());
		e.setWorkout(workout);
		
		return e;
	}

	public static ExerciseResponseDTO toDto(Exercise e) {
		if (e == null)
			return null;
		
		ExerciseResponseDTO r = new ExerciseResponseDTO();
		r.setExerciseId(e.getExerciseId());
		r.setExerciseName(e.getExerciseName());
		r.setSets(e.getSets());
		r.setReps(e.getReps());
		r.setWeightUsed(e.getWeightUsed());
		r.setDiffcultyLevel(e.getDiffcultyLevel());
		if (e.getWorkout() != null)
			r.setWorkoutId(e.getWorkout().getWorkoutId());
		
		return r;
	}

}
