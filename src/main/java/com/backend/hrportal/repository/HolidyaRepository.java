package com.backend.hrportal.repository;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface HolidyaRepository extends JpaRepository<Holiday , Long> {
    @Query("select a from Holiday a where a.registrationDate <= :endD and a.registrationDate >= :start")
    List<Holiday> findAllByDateReservationBetweenss(@Param("start") Date start, @Param("endD") Date endD);

}
