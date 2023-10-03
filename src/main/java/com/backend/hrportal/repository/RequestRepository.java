package com.backend.hrportal.repository;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request,Long> {
    @Query("select a from Request a where a.registrationDate <= :endD and a.registrationDate >= :start and a.user.id =:id")
    List<Request> findAllByDateRequestBetweenss(@Param("id") Long id,@Param("start") Date start, @Param("endD") Date endD);

}
