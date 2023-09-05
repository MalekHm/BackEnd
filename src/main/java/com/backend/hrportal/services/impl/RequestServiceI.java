package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Request;
import com.backend.hrportal.repository.RequestRepository;
import com.backend.hrportal.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RequestServiceI implements RequestService {

    @Autowired
    private RequestRepository requestRepository;
    @Override
    public List<Request> getList() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> filterByDate(Date start, Date end) {
        return requestRepository.findAllByDateRequestBetweenss(start,end);
    }
}
