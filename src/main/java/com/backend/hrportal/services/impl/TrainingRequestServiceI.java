package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.TrainingRequest;
import com.backend.hrportal.repository.TrainingRepository;
import com.backend.hrportal.repository.TrainingRequetsRepository;
import com.backend.hrportal.services.TrainingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingRequestServiceI implements TrainingRequestService {

    @Autowired
    private TrainingRequetsRepository trainingRequetsRepository;
    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public List<TrainingRequest> getListByUser(Long id) {
        return trainingRequetsRepository.findAllByUser(id);
    }

    @Override
    public List<TrainingRequest> getListByTraining(Long id) {
        return trainingRequetsRepository.findAllByUser(id);
    }

    @Override
    public TrainingRequest confirmed(Long id) {
        Optional<TrainingRequest> trainingRequest=trainingRequetsRepository.findById(id);

        trainingRequest.get().setStatus(true);

        TrainingRequest trainingRequest1 =trainingRequest.get();
        return trainingRequetsRepository.save(trainingRequest1);

    }
}
