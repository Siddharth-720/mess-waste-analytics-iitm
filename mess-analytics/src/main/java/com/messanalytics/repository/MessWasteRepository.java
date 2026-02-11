package com.messanalytics.repository;

import com.messanalytics.model.MessWaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessWasteRepository extends JpaRepository<MessWaste, Long> {
}