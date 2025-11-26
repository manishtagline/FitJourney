package com.example.fitjourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitjourney.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{

}
