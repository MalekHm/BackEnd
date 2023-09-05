package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Contract;
import com.backend.hrportal.repository.ContratRepository;
import com.backend.hrportal.services.ContartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContartServiceI implements ContartService {
    @Autowired
    private ContratRepository contratRepository;
    @Override
    public List<Contract> listContract() {
        return contratRepository.findAll();
    }
}
