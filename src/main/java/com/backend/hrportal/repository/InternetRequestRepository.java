package com.backend.hrportal.repository;

import com.backend.hrportal.models.InternetRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternetRequestRepository extends JpaRepository<InternetRequest,Long> {
}
