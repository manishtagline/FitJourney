package com.example.fitjourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitjourney.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long>{

}
