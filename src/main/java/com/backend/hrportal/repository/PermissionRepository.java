package com.backend.hrportal.repository;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    @Query("select a from Permission a where a.registrationDate <= :endD and a.registrationDate >= :start")
    List<Permission> findAllByDatePermissionBetweenss(@Param("start") Date start, @Param("endD") Date endD);

}
