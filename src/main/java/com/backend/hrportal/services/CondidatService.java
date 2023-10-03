package com.backend.hrportal.services;

import com.backend.hrportal.models.Condidat;
import com.backend.hrportal.repository.CondidatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CondidatService {



   Condidat addCondidat(Condidat condidat) ;

   List<Condidat> getCondidatByPosition(Long id);
}
