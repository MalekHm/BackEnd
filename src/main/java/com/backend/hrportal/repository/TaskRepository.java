package com.backend.hrportal.repository;

import com.backend.hrportal.models.Remote;
import com.backend.hrportal.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("select a from Task a where a.registrationDate <= :endD and a.registrationDate >= :start")
    List<Task> findAllByDateTaskBetweenss(@Param("start") Date start, @Param("endD") Date endD);

}
