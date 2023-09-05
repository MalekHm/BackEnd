package com.backend.hrportal.repository;

import com.backend.hrportal.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training,Long> {
}
