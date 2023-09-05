package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Request;
import com.backend.hrportal.models.Task;
import com.backend.hrportal.services.RequestService;
import com.backend.hrportal.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping("/all")
    public ResponseEntity<List<Request>> getTasks(){
        List<Request> requests=  requestService.getList();
        return ResponseEntity.ok().body(requests);
    }
    @GetMapping("/filtreByDate/{start}/{end}")
    public ResponseEntity<List<Request>> filtreByDate(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            Date end) {
        List <Request> requests= requestService.filterByDate(start,end);
        return ResponseEntity.ok().body(requests);
    }
}

