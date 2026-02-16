package com.messanalytics.repository;

import com.messanalytics.model.MessWaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessWasteRepository extends JpaRepository<MessWaste, Long> {

    // Day 4: Custom query to get average waste for a specific meal
    @Query("SELECT AVG(m.foodWastedKg) FROM MessWaste m WHERE m.mealType = ?1")
    Double getAverageWasteByMealType(String mealType);
}