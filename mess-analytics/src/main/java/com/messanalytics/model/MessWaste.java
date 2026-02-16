package com.messanalytics.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MessWaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String mealType;
    private double foodProducedKg;
    private double foodConsumedKg;
    private double foodWastedKg;

    @PrePersist @PreUpdate
    public void calculate() {
        this.foodWastedKg = this.foodProducedKg - this.foodConsumedKg;
    }

    // --- PASTE YOUR GENERATED GETTERS AND SETTERS HERE ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public double getFoodProducedKg() {
        return foodProducedKg;
    }

    public void setFoodProducedKg(double foodProducedKg) {
        this.foodProducedKg = foodProducedKg;
    }

    public double getFoodConsumedKg() {
        return foodConsumedKg;
    }

    public void setFoodConsumedKg(double foodConsumedKg) {
        this.foodConsumedKg = foodConsumedKg;
    }

    public double getFoodWastedKg() {
        return foodWastedKg;
    }

    public void setFoodWastedKg(double foodWastedKg) {
        this.foodWastedKg = foodWastedKg;
    }
}