package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Contract;
import com.backend.hrportal.models.Training;
import com.backend.hrportal.payload.request.ContractRequest;
import com.backend.hrportal.services.ContartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addContrat")
    public ResponseEntity<Contract> addContrat(@RequestBody ContractRequest contractRequest){
        contartService.addContrat(contractRequest);
        return ResponseEntity.ok().body(contartService.addContrat(contractRequest));
    }

    @GetMapping("/getContrat/{id}")
    public ResponseEntity<Contract> getContrat(@PathVariable("id") Long id){
        Contract contract=  contartService.getContrat(id);
        return ResponseEntity.ok().body(contract);
    }
}
