package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Notification;
import com.backend.hrportal.models.User;
import com.backend.hrportal.repository.NotificationRepository;
import com.backend.hrportal.repository.UserRepository;
import com.backend.hrportal.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceI implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification newNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotification(Long id) {


        return notificationRepository.findNotificationByUserId(id);
    }

    @Override
    public List<Notification> getListNotification(Long id) {
        return notificationRepository.listNotification(id);
    }

    @Override
    public void putVU(Long id) {
        Notification notification= notificationRepository.findById(id).get();
        notification.setVu(true);
        notificationRepository.save(notification);

    }
}
