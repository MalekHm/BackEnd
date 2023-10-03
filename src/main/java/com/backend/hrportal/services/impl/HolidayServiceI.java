package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Notification;
import com.backend.hrportal.repository.HolidyaRepository;
import com.backend.hrportal.services.HolidayService;
import com.backend.hrportal.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HolidayServiceI implements HolidayService {

    @Autowired
    private HolidyaRepository holidyaRepository;

    @Autowired
    private EmailService emailService;


    @Autowired
    private NotificationService notificationService;
    @Override
    public List<Holiday> getList() {
        return holidyaRepository.findAll();
    }

    @Override
    public Holiday confirmed(Long id,String newStatus) {
        Optional<Holiday> holiday=holidyaRepository.findById(id);
        holiday.get().setStatus( newStatus);
        Notification notification=   new Notification("Your request for holiday for period from : " +holiday.get().getStart() +"to" + holiday.get().getEnd() + "is "+newStatus );
        notification.setUser(holiday.get().getUser());
        notificationService.newNotification(notification);

        emailService.sendResponseHoliday(holiday.get().getUser().getEmail(),holiday.get().getStart(), holiday.get().getEnd());
        holidyaRepository.save(holiday.get());
        return  holidyaRepository.save(holiday.get());
    }

    @Override
    public List<Holiday> filterByDate(Date start, Date end) {
        return holidyaRepository.findAllByDateReservationBetweenss(start,end);
    }


}
