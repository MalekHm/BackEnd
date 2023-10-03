package com.backend.hrportal.services;

import com.backend.hrportal.models.Calendar;

import java.util.List;

public interface CalendarService {

    public Calendar addCalendar(Calendar calendar);
    public List<Calendar> getAll();
}
