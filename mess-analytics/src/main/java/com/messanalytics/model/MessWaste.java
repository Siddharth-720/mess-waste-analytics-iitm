package com.messanalytics.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MessWaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String mealType; // Breakfast, Lunch, Dinner
    private double foodProducedKg;
    private double foodConsumedKg;
    private double foodWastedKg;

    // This calculates waste automatically before saving
    @PrePersist
    @PreUpdate
    public void calculateWaste() {
        this.foodWastedKg = this.foodProducedKg - this.foodConsumedKg;
    }

    // Standard Getters and Setters
}