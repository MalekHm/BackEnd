package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Notification;
import com.backend.hrportal.models.Permission;
import com.backend.hrportal.models.Remote;
import com.backend.hrportal.repository.PermissionRepository;
import com.backend.hrportal.services.HolidayService;
import com.backend.hrportal.services.NotificationService;
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

    @Autowired
    private NotificationService notificationService;

    @Override
    public List<Permission> getList() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission confirmed(Long id,String newStatus) {
        Optional<Permission> permission=permissionRepository.findById(id);
        permission.get().setStatus(newStatus);
        Notification notification=   new Notification("Your request for permission for period from : " +permission.get().getStart() +"to" + permission.get().getEnd() +" for date : " +permission.get().getRegistrationDate() + "is"+newStatus );
        notification.setUser(permission.get().getUser());
        notificationService.newNotification(notification);

        emailService.sendResponsePermission(permission.get().getUser().getEmail(),permission.get().getStart(), permission.get().getEnd());
        permissionRepository.save(permission.get());
        return  permissionRepository.save(permission.get());

    }

    @Override
    public List<Permission> filterByDate(Date start, Date end) {
        return permissionRepository.findAllByDatePermissionBetweenss(start,end);
    }
}
