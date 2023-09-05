package com.backend.hrportal.repository;

import com.backend.hrportal.models.Task;
import com.backend.hrportal.models.TrainingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TrainingRequetsRepository extends JpaRepository<TrainingRequest,Long> {


    @Query("select a from TrainingRequest a where a.user.id =:id")
    List<TrainingRequest> findAllByUser(@Param("id") Long id);

    List<TrainingRequest> findByTraining(Long id);


}
