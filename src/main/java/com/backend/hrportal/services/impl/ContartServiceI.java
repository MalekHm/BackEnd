package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Contract;
import com.backend.hrportal.models.User;
import com.backend.hrportal.payload.request.ContractRequest;
import com.backend.hrportal.repository.CondidatRepository;
import com.backend.hrportal.repository.ContratRepository;
import com.backend.hrportal.repository.UserRepository;
import com.backend.hrportal.services.ContartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContartServiceI implements ContartService {
    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Contract> listContract() {
        return
                contratRepository.findAll();
    }

    @Override
    public Contract addContrat(ContractRequest contractRequest) {

        User user=userRepository.findById(contractRequest.getEmployee()).get();

        Contract contract=new Contract(
                contractRequest.getType(),user,contractRequest.getDuration(),contractRequest.getNature(),
                contractRequest.getWorkingCalendar(),contractRequest.getStartDate(),contractRequest.getEndDate());
        contratRepository.save(contract);
        return contract;
    }

    @Override
    public Contract getContrat(Long id) {
        return contratRepository.getContrat(id);
    }
}
