package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Calendar;
import com.backend.hrportal.repository.CalendarRepository;
import com.backend.hrportal.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceI implements CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;
    @Override
    public Calendar addCalendar(Calendar calendar) {
        return this.calendarRepository.save(calendar);
    }

    @Override
    public List<Calendar> getAll() {
        return  this.calendarRepository.findAll();
    }
}
