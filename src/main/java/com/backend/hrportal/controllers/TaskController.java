package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Task;
import com.backend.hrportal.models.Training;
import com.backend.hrportal.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getTasks(){
        List<Task> tasks=  taskService.getList();
        return ResponseEntity.ok().body(tasks);
    }
    @GetMapping("/filtreByDate/{start}/{end}")
    public ResponseEntity<List<Task>> filtreByDate(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            Date end) {
        List <Task> tasks= taskService.filterByDate(start,end);
        return ResponseEntity.ok().body(tasks);
    }
}
