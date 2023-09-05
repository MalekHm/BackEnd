package com.backend.hrportal.repository;

import com.backend.hrportal.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Long> {
}
