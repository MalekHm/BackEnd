package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Notification;
import com.backend.hrportal.models.Request;
import com.backend.hrportal.repository.RequestRepository;
import com.backend.hrportal.services.NotificationService;
import com.backend.hrportal.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceI implements RequestService {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private NotificationService notificationService;
    @Override
    public List<Request> getList() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> filterByDate(Long id,Date start, Date end) {
        return requestRepository.findAllByDateRequestBetweenss(id,start,end);
    }

    @Override
    public Request confirmed(Long id, String newStatus) {
        Optional<Request> request=requestRepository.findById(id);
        request.get().setStatus(  newStatus);
        Notification notification=   new Notification("Your request for   : " +request.get().getDescription() + "is"+newStatus );
        notification.setUser(request.get().getUser());
        notificationService.newNotification(notification);

//        emailService.sendResponseHoliday(request.get().getUser().getEmail(),request.get().getStart(), holiday.get().getEnd());
//

        return  requestRepository.save(request.get());
    }
}
