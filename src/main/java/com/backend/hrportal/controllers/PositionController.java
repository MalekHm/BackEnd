package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Position;
import com.backend.hrportal.models.Training;
import com.backend.hrportal.services.PositionService;
import com.backend.hrportal.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping("/addPosition")
    public Position addPosition(@RequestBody Position position){

        return  positionService.addPosition(position);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Position>> getTrainings(){
        List<Position> positions=  positionService.getList();
        return ResponseEntity.ok().body(positions);
    }
}
