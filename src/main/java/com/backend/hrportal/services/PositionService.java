package com.backend.hrportal.services;

import com.backend.hrportal.models.Position;
import com.backend.hrportal.models.Training;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {
    public List<Position> getList();
    public Position addPosition( Position position);

}
