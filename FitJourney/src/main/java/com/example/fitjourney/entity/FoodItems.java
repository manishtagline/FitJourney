package com.example.fitjourney.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "food_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItems {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "items_id")
    private Long itemsId;
    
    private String foodName;
    
    private Double calories;
    
    private Double protein;
    
    private Double carbs;
    
    private Double fats;
	
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
    
}
