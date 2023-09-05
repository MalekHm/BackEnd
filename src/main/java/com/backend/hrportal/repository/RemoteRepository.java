package com.backend.hrportal.repository;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Remote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RemoteRepository extends JpaRepository<Remote,Long> {
    @Query("select a from Remote a where a.registrationDate <= :endD and a.registrationDate >= :start")
    List<Remote> findAllByDateRemoteBetweenss(@Param("start") Date start, @Param("endD") Date endD);

}
