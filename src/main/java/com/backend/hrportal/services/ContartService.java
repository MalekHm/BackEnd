package com.backend.hrportal.services;

import com.backend.hrportal.models.Contract;
import com.backend.hrportal.payload.request.ContractRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContartService {
    public List<Contract> listContract();

    public  Contract addContrat(ContractRequest ContractRequest);

    public Contract getContrat(Long id);
}
