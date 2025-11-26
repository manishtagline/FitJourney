package com.example.fitjourney.entity;

import com.example.fitjourney.entity.enums.DifficultyLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercise")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;
    
    @Column(name = "exercise_name")
    private String exerciseName;
    
    @Column(name = "sets")
    private int sets;
    
    @Column(name = "reps")
    private int reps;
    
    @Column(name = "weight_used")
    private Double weightUsed;
    
    @Enumerated(EnumType.STRING)
    private DifficultyLevel diffcultyLevel;
    
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
	
}
