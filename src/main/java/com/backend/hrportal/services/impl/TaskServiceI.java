package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Task;
import com.backend.hrportal.repository.TaskRepository;
import com.backend.hrportal.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceI implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> getList() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> filterByDate(Date start, Date end) {
        return taskRepository.findAllByDateTaskBetweenss(start,end);
    }


}
