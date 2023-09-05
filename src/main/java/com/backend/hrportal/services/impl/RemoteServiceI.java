package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Remote;
import com.backend.hrportal.repository.RemoteRepository;
import com.backend.hrportal.services.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteServiceI implements RemoteService {
    @Autowired
    private EmailService emailService;
    @Autowired
    private RemoteRepository remoteRepository;
    @Override
    public List<Remote> getList() {
        return remoteRepository.findAll();
    }

    @Override
    public Remote confirmed(Long id) {
        Optional<Remote> remote=remoteRepository.findById(id);
        remote.get().setValide(true);
        emailService.sendResponseRemote(remote.get().getUser().getEmail(),remote.get().getStart(), remote.get().getEnd());
        remoteRepository.save(remote.get());
        return  remoteRepository.save(remote.get());
    }

    @Override
    public List<Remote> filterByDate(Date start, Date end) {
        return remoteRepository.findAllByDateRemoteBetweenss(start,end);
    }
}
