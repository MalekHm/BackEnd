package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Contract;
import com.backend.hrportal.models.Training;
import com.backend.hrportal.services.ContartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/contract")


public class ContractController {

    @Autowired
      ContartService contartService;

    @GetMapping("/all")
    public ResponseEntity<List<Contract>> getTrainings(){
        List<Contract> contracts=  contartService.listContract();
        return ResponseEntity.ok().body(contracts);
    }
}
