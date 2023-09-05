package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Permission;
import com.backend.hrportal.models.Remote;
import com.backend.hrportal.repository.PermissionRepository;
import com.backend.hrportal.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceI implements PermissionService {
    @Autowired
    private EmailService emailService;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getList() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission confirmed(Long id) {
        Optional<Permission> permission=permissionRepository.findById(id);
        permission.get().setValide(true);
        emailService.sendResponsePermission(permission.get().getUser().getEmail(),permission.get().getStart(), permission.get().getEnd());
        permissionRepository.save(permission.get());
        return  permissionRepository.save(permission.get());

    }

    @Override
    public List<Permission> filterByDate(Date start, Date end) {
        return permissionRepository.findAllByDatePermissionBetweenss(start,end);
    }
}
