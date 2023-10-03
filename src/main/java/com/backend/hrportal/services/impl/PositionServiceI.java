package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Condidat;
import com.backend.hrportal.models.Position;
import com.backend.hrportal.models.User;
import com.backend.hrportal.payload.request.CondidatRequest;
import com.backend.hrportal.repository.CondidatRepository;
import com.backend.hrportal.repository.PositionRepository;
import com.backend.hrportal.repository.UserRepository;
import com.backend.hrportal.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceI  implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private CondidatRepository condidatRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Position> getList() {
        return positionRepository.findAll();
    }

    @Override
    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }
    private final Path root = Paths.get("./uploads");
    @Override
    public Condidat recomande(CondidatRequest condidatRequest) {
        if (!Files.exists(root)) {
            try {
                Files.createDirectories(root);
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload!");
            }
        }
        try {
            Files.copy(condidatRequest.getFile().getInputStream(),
                    this.root.resolve(condidatRequest.getFile().getOriginalFilename()));
            Optional<User> user=userRepository.findById(condidatRequest.getUser());


            Optional<Position> position=positionRepository.findById(condidatRequest.getPosition());
             Condidat condidat=new Condidat(condidatRequest.getCondidat());
             condidat.setEmployee(user.get());
             condidat.setPosition(position.get());
            condidat.setCv(condidatRequest.getFile().getOriginalFilename());
             condidatRepository.save(condidat);
            return condidat;
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }

            throw new RuntimeException(e.getMessage());
        }
    }
}
