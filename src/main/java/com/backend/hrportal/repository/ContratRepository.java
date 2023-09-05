package com.backend.hrportal.repository;

import com.backend.hrportal.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ContratRepository extends JpaRepository<Contract,Long> {
}
