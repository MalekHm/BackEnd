package com.backend.hrportal.repository;

import com.backend.hrportal.models.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar,Long> {
}
