package com.backend.hrportal.services;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Request;
import com.backend.hrportal.models.Task;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface RequestService {
    public List<Request> getList();
    public List<Request>filterByDate(Long id,Date start, Date end);
    public Request confirmed(Long id, String newStatus);
}
