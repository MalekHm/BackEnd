package com.backend.hrportal.services;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Remote;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface RemoteService {
    public List<Remote> getList();
    public Remote confirmed( Long id);
    public List<Remote>filterByDate(Date start, Date end);


}

