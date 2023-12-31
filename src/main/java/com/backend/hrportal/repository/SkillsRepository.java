package com.backend.hrportal.repository;

import com.backend.hrportal.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillsRepository extends JpaRepository<Skills,Long> {

    Optional<Skills> findByTitle(String title);
}
