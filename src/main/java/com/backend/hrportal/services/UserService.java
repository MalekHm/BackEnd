package com.backend.hrportal.services;

import com.backend.hrportal.exception.ResourceNotFoundException;
import com.backend.hrportal.models.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface UserService {
    public List<User> allUser();
    void deleteUser(Long id);
    public User updateUser(Long id,User user)throws ResourceNotFoundException;
    public User aboutMe(Long id,String aboutMe)throws ResourceNotFoundException;
    public User findUser(Long id)throws ResourceNotFoundException;

    public User addSkills(Long id, List<Skills> skills)throws ResourceNotFoundException;
    public User addEducation(Long id, List<Education> education)throws ResourceNotFoundException;

    public User addExperience(Long id, List<Experience> experience)throws ResourceNotFoundException;
    public User addChild(Long id, ChildRequest childRequest)throws ResourceNotFoundException;

    public User addGym(Long id, GymRequest gymRequest)throws ResourceNotFoundException;
    public User addRequest(Long id, Request request)throws ResourceNotFoundException;
    public User addInternet(Long id, InternetRequest internetRequest)throws ResourceNotFoundException;

    public User addPresence(Long id, Presence presence)throws ResourceNotFoundException;
    public User addHoliday(Long id, Holiday holiday)throws ResourceNotFoundException;

    public User addPermission(Long id, Permission permission)throws ResourceNotFoundException;
    public User addRemote(Long id, Remote remote)throws ResourceNotFoundException;
    public User addTask(Long id, Task task) throws ResourceNotFoundException;

    public List<User> search(String key);

}
