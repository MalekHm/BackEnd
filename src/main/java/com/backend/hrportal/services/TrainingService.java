package com.backend.hrportal.services;

import com.backend.hrportal.exception.ResourceNotFoundException;
import com.backend.hrportal.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TrainingService {
    public List<Training> getList();
    public Training addTraining( Training training);

    public Boolean requestTrainings (Long userId, Long trainingId);
}
