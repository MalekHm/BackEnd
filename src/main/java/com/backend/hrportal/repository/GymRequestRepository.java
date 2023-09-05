package com.backend.hrportal.repository;

import com.backend.hrportal.models.GymRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRequestRepository extends JpaRepository<GymRequest,Long> {
}
