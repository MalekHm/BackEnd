package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Training;
import com.backend.hrportal.models.User;
import com.backend.hrportal.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping("/addTraining")
    public Training addTraining(@RequestBody Training training){

        return  trainingService.addTraining(training);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Training>> getTrainings(){
        List<Training> trainings=  trainingService.getList();
        return ResponseEntity.ok().body(trainings);
    }

    @GetMapping("/request/{userId}/{trainingId}")
    public ResponseEntity<HttpStatus>requestTrainings(@PathVariable (value = "userId") Long userId, @PathVariable (value = "trainingId") Long trainingId){
          if (!trainingService.requestTrainings(userId,trainingId)) {
              return new ResponseEntity<>(HttpStatus.CREATED);
          }else{
              return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
          }
    }
}
