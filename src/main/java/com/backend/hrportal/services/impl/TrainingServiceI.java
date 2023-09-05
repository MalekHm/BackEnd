package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Role;
import com.backend.hrportal.models.Training;
import com.backend.hrportal.models.TrainingRequest;
import com.backend.hrportal.models.User;
import com.backend.hrportal.repository.TrainingRepository;
import com.backend.hrportal.repository.TrainingRequetsRepository;
import com.backend.hrportal.repository.UserRepository;
import com.backend.hrportal.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TrainingServiceI implements TrainingService {

    @Autowired
   private TrainingRepository trainingRepository;

    @Autowired
    private TrainingRequetsRepository trainingRequetsRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Training> getList() {

        return  trainingRepository.findAll();

    }

    @Override
    public Training addTraining(Training training) {


        return trainingRepository.save(training);
    }

    @Override
    public Boolean requestTrainings(Long userId, Long trainingId) {
        Optional<User> user= userRepository.findById(userId);
        Optional<Training> training= trainingRepository.findById(trainingId);
        Training training1=training.get();
        User user1=user.get();
        System.out.println("ok welcome");
        if(user1.getTrainings().contains(training1)){
            return false;
        }else {

            TrainingRequest trainingRequest=new TrainingRequest(user1,training1);


            user1.getTrainings().add(training1);

            userRepository.save(user1);


            trainingRequetsRepository.save(trainingRequest);
            trainingRepository.save(training1);
            return true;
        }
    }
}
