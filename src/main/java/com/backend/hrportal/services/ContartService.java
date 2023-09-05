package com.backend.hrportal.services;

import com.backend.hrportal.models.Contract;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContartService {
    public List<Contract> listContract();
}
