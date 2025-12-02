package com.example.fitjourney.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fitjourney.entity.Goal;
import com.example.fitjourney.entity.enums.GoalType;

public interface GoalRepository extends JpaRepository<Goal, Long>{

	List<Goal> findByProfileProfileId(Long profileId);
    List<Goal> findByProfileProfileIdAndGoalType(Long profileId, GoalType type);
    List<Goal> findByProfileProfileIdAndStartDateBetween(Long profileId, LocalDate start, LocalDate end);

    // Custom JPQL: active goals
    @Query("SELECT g FROM Goal g WHERE g.profile.profileId = :profileId AND (g.endDate IS NULL OR g.endDate >= CURRENT_DATE)")
    List<Goal> findActiveGoalsByProfileId(@Param("profileId") Long profileId);

    // Progress as percentage (current/target *100)
    @Query("SELECT g.goalId, (CASE WHEN g.targetValue > 0 THEN (g.currentValue/g.targetValue)*100 ELSE 0 END) FROM Goal g WHERE g.profile.profileId = :profileId")
    List<Object[]> findGoalProgressByProfile(@Param("profileId") Long profileId);
	
}
