package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Calendar;
import com.backend.hrportal.models.Document;
import com.backend.hrportal.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @PostMapping("/event")
    public ResponseEntity<Calendar> addCalendar(@RequestBody Calendar calendar){
    return ResponseEntity.status(HttpStatus.OK).body( calendarService.addCalendar(calendar));

    }
    @GetMapping("/all")
    public ResponseEntity<List<Calendar>> getAll( ) {
        return ResponseEntity.status(HttpStatus.OK).body( calendarService.getAll());
    }
}
