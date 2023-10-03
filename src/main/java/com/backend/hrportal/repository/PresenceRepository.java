package com.backend.hrportal.repository;

import com.backend.hrportal.models.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Presence,Long> {
}
