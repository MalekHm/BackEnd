package com.backend.hrportal.repository;

import com.backend.hrportal.models.Contract;
import com.backend.hrportal.models.TrainingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ContratRepository extends JpaRepository<Contract,Long> {
    @Query("select a from Contract a where a.employee.id =:id")
    Contract getContrat(@Param("id") Long id);
}
