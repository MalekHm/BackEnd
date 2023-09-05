package com.backend.hrportal.services;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Training;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface HolidayService {
    public List<Holiday> getList();
    public Holiday confirmed( Long id);

    public List<Holiday>filterByDate(Date start, Date end);


}