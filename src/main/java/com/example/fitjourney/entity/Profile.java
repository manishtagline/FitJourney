package com.example.fitjourney.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.fitjourney.entity.enums.DifficultyLevel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int age;
    private Double height; 
    private Double weight; 

    @Enumerated(EnumType.STRING)
    private DifficultyLevel fitnessLevel;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Goal> goals = new ArrayList<>();


    public Double calculateBMI() {
        if (weight != null && height != null && height > 0) {
            double heightInMeters = height / 100.0;
            return weight / (heightInMeters * heightInMeters);
        }
        return null;
    }
    
	
}
