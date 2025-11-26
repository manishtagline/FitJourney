package com.example.fitjourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitjourney.entity.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long>{

}
