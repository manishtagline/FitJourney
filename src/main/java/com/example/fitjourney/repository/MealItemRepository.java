package com.example.fitjourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitjourney.entity.MealItem;

public interface MealItemRepository extends JpaRepository<MealItem, Long>{

}
