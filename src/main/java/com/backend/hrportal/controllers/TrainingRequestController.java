package com.backend.hrportal.controllers;

import com.backend.hrportal.models.TrainingRequest;
import com.backend.hrportal.services.TrainingRequestService;
import com.backend.hrportal.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/trainingRequets")
public class TrainingRequestController {
    @Autowired
    private TrainingRequestService trainingRequestService;

    @GetMapping("/allByUser/{id}")
    public List<TrainingRequest> allByUser(@PathVariable("id") Long id){
        return trainingRequestService.getListByUser(id);
    }

    @GetMapping("/getListRequest/{id}")
    public List<TrainingRequest> getListRequest(@PathVariable("id") Long id){
        return trainingRequestService.getListRequest(id);
    }

    @GetMapping("/confirmed/{id}")
    public TrainingRequest confirmed(@PathVariable("id") Long id){
        return trainingRequestService.confirmed(id);
    }
}
