package com.example.fitjourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitjourney.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
