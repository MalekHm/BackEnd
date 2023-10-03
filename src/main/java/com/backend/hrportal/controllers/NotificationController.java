package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Notification;
import com.backend.hrportal.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
 private   NotificationService notificationService;

    @GetMapping("/getNotification/{id}")
    public List<Notification> getNotification(@PathVariable(name = "id") Long id){
        return notificationService.getNotification(id);
    }

    @GetMapping("/getListNotification/{id}")
    public List<Notification> getListNotification(@PathVariable(name = "id") Long id){
        return notificationService.getListNotification(id);
    }
    @PutMapping("/putVU/{id}")
    public void putVU(@PathVariable(name = "id") Long id){
          notificationService.putVU(id);
    }
}
