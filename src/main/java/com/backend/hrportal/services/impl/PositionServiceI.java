package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Position;
import com.backend.hrportal.repository.PositionRepository;
import com.backend.hrportal.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceI  implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> getList() {
        return positionRepository.findAll();
    }

    @Override
    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }
}
