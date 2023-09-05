package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.repository.HolidyaRepository;
import com.backend.hrportal.services.HolidayService;
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
    @Override
    public List<Holiday> getList() {
        return holidyaRepository.findAll();
    }

    @Override
    public Holiday confirmed(Long id) {
        Optional<Holiday> holiday=holidyaRepository.findById(id);
        holiday.get().setValide(true);
        emailService.sendResponseHoliday(holiday.get().getUser().getEmail(),holiday.get().getStart(), holiday.get().getEnd());
        holidyaRepository.save(holiday.get());
        return  holidyaRepository.save(holiday.get());
    }

    @Override
    public List<Holiday> filterByDate(Date start, Date end) {
        return holidyaRepository.findAllByDateReservationBetweenss(start,end);
    }


}
