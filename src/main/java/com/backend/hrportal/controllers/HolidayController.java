package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.User;
import com.backend.hrportal.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/holiday")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;
    @GetMapping("/all")
    public ResponseEntity<List<Holiday>> getAllEmployees() {
        List <Holiday> holidays= holidayService.getList();
        return ResponseEntity.ok().body(holidays);
    }
    @GetMapping("/confirmed/{id}/{newStatus}")
    public   ResponseEntity<Holiday> confirmed(@PathVariable(value = "id") Long id,
                                               @PathVariable(value = "newStatus") String newStatus){
       Holiday holiday= holidayService.confirmed(id,newStatus);
        return ResponseEntity.ok().body(holiday);
    }
    @GetMapping("/filtreByDate/{start}/{end}")
    public ResponseEntity<List<Holiday>> filtreByDate(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            Date end
    ) {
        List <Holiday> holidays= holidayService.filterByDate(start,end);
        return ResponseEntity.ok().body(holidays);
    }
}
