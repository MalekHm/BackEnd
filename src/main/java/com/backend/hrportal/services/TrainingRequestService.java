package com.backend.hrportal.services;

import com.backend.hrportal.models.TrainingRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TrainingRequestService {
    List<TrainingRequest> getListByUser(Long id);
    List<TrainingRequest> getListByTraining(Long id);
    TrainingRequest confirmed(Long id);

    List<TrainingRequest> getListRequest(Long id);


}
