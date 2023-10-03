package com.backend.hrportal.services;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Task;
import com.backend.hrportal.models.Training;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface TaskService {
    public List<Task> getList();
    public List<Task>filterByDate(Long id,Date start, Date end);

}
