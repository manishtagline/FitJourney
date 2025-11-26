package com.example.fitjourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitjourney.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
