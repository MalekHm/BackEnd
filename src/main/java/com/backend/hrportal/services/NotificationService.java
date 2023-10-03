package com.backend.hrportal.services;

import com.backend.hrportal.models.Notification;

import java.util.List;

public interface NotificationService {

    public Notification newNotification(Notification notification);

    public List<Notification> getNotification(Long id);
    public List<Notification> getListNotification(Long id);
    void putVU(Long id);
}
