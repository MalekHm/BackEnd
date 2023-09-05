package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Remote;
import com.backend.hrportal.services.HolidayService;
import com.backend.hrportal.services.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/remote")
public class RemoteController {
    @Autowired
    private RemoteService remoteService;
    @GetMapping("/all")
    public ResponseEntity<List<Remote>> getAllEmployees() {
        List <Remote> remoteList= remoteService.getList();
        return ResponseEntity.ok().body(remoteList);
    }
    @GetMapping("/confirmed/{id}")
    public   ResponseEntity<Remote> confirmed(@PathVariable(value = "id") Long id) {
        Remote remote= remoteService.confirmed(id);
        return ResponseEntity.ok().body(remote);
    }
    @GetMapping("/filtreByDate/{start}/{end}")
    public ResponseEntity<List<Remote>> filtreByDate(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            Date end
    ) {
        List <Remote> remotes= remoteService.filterByDate(start,end);
        return ResponseEntity.ok().body(remotes);
    }
}

