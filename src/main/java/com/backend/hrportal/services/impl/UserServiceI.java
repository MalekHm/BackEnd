package com.backend.hrportal.services.impl;

import com.backend.hrportal.exception.ResourceNotFoundException;
import com.backend.hrportal.models.*;
import com.backend.hrportal.repository.*;
import com.backend.hrportal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceI implements UserService {
    private final UserRepository userRepository;

    private final InternetRequestRepository internetRequestRepository;
    private final PasswordEncoder encoder;
    private final SkillsRepository skillsRepository;
    private final GymRequestRepository gymRequestRepository;
    private final ChildRequestRepository childRequestRepository;

    private final PresenceRepository presenceRepository;

    private final HolidyaRepository holidyaRepository;

    private final ExperienceRepository experienceRepository;

    private final PermissionRepository permissionRepository;

    private final RemoteRepository remoteRepository;

    private final EducationRepository eucationRepository;

    private final TaskRepository taskRepository;
    private final RequestRepository requestRepository;

    public List<User> allUser(){

        List<User> list=this.userRepository.findAll();
        return list;
    }

    public User findUser(Long id) throws ResourceNotFoundException{

        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
    }
    @Override
    public User addSkills(Long id, List<Skills> skills ) throws ResourceNotFoundException {
        Optional<User> user=userRepository.findById(id);

        User _user=user.get();
        skills.forEach(el->{
        Skills skills1=new Skills(el.getTitle(),el.getScore());
        if(!skillsRepository.findByTitle(skills1.getTitle()).isPresent()){
         skills1.setUser(_user);
        skillsRepository.save(skills1);
            if(!_user.getSkills().contains(skills1)){
                _user.getSkills().add(skills1);
            }
        }
        });
        return userRepository.save(_user);

    }
    @Override
    public User addEducation(Long id, List<Education> educations) throws ResourceNotFoundException {
        Optional<User> user=userRepository.findById(id);

        User _user=user.get();
        educations.forEach(el->{
            Education education=new Education(el.getDiplome(),el.getUniversite(),el.getPassingYear(),el.getDegree());

            education.setUser(_user);
            eucationRepository.save(education);
                if(!_user.getEducations().contains(education)){
                    _user.getEducations().add(education);
                }
            });

        return userRepository.save(_user);

    }
    @Override
    public User addExperience(Long id, List<Experience> experiences) throws ResourceNotFoundException {
        Optional<User> user=userRepository.findById(id);

        User _user=user.get();
        experiences.forEach(el->{
            System.out.println(el.getExperience());
            Experience experience=new Experience(el.getJobTitle(),el.getJobDescription(),
                    el.getEmployer(),el.getExperience(),el.getStartDate());

            experience.setUser(_user);
            experienceRepository.save(experience);
            if(!_user.getExperiences().contains(experience)){
                _user.getExperiences().add(experience);
            }
        });

        return userRepository.save(_user);

    }
    @Override
    public User addChild(Long id, ChildRequest childRequest) throws ResourceNotFoundException {

        childRequestRepository.save(childRequest);
        Optional<User> user=userRepository.findById(id);
        User _user=user.get();
        if(user.isPresent()) {
          _user.getChildRequestList().add(childRequest);


        }

        return userRepository.save(_user);
    }

    @Override
    public User addGym(Long id, GymRequest gymRequest) throws ResourceNotFoundException {
        gymRequestRepository.save(gymRequest);

        Optional<User> user=userRepository.findById(id);

        User _user=user.get();
        if(user.isPresent()) {
            System.out.println(gymRequest.toString());
            _user.getGymRequests().add(gymRequest);
        }

        return userRepository.save(_user);
    }
    @Override
    public User addInternet(Long id, InternetRequest internetRequest) throws ResourceNotFoundException {

        internetRequestRepository.save(internetRequest);
        Optional<User> user=userRepository.findById(id);
        User _user=user.get();
        if(user.isPresent()) {
            _user.getInternetRequests().add(internetRequest);
        }
        return userRepository.save(_user);
    }

    @Override
    public User addPresence(Long id, Presence presence) throws ResourceNotFoundException {

        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            User _user=user.get();
            _user.getPresences().add(presence);
            presenceRepository.save(presence);
            userRepository.save(_user);
            return _user;
        }
        return null;
    }

    @Override
    public User addHoliday(Long id, Holiday holiday) throws ResourceNotFoundException {
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            User _user=user.get();
            _user.getHolidays().add(holiday);
            holiday.setUser(_user);
            holidyaRepository.save(holiday);
            userRepository.save(_user);
            return _user;
        }
        return null;
    }
    @Override
    public User addPermission(Long id, Permission permission) throws ResourceNotFoundException {
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            User _user=user.get();
            _user.getPermissions().add(permission);
            permission.setUser(_user);
            permissionRepository.save(permission);
            userRepository.save(_user);
            return _user;
        }
        return null;
    }

    @Override
    public User addRemote(Long id, Remote remote) throws ResourceNotFoundException {
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            User _user=user.get();
            _user.getRemotes().add(remote);
            remote.setUser(_user);
            remoteRepository.save(remote);
            userRepository.save(_user);
            return _user;
        }
        return null;
    }
    @Override
    public User addTask(Long id, Task task) throws ResourceNotFoundException {
        Task task1=new Task(task.getTitle(),task.getDescription());
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            User _user=user.get();
            _user.getTasks().add(task1);
            task1.setUser(_user);
            taskRepository.save(task1);
            userRepository.save(_user);
            return _user;
        }
        return null;
    }

    @Override
    public List<User> search(String key) {
        return userRepository.findByUsernameContaining(key);
    }

    @Override
    public User addRequest(Long id, Request request) throws ResourceNotFoundException {
        Request request1=new Request(request.getSubject(),request.getDescription());
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            User _user=user.get();
            _user.getRequests().add(request1);
            request1.setUser(_user);
            requestRepository.save(request1);
            userRepository.save(_user);
            return _user;
        }
        return null;
    }

    public User updateUser(Long id,User user)throws ResourceNotFoundException{
     User _user=   userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Event with id = " + id));
    System.out.println(user.getPassword()=="" );
     if(user.getPassword()=="") {
         _user.setEmail(user.getEmail());
         _user.setUsername(user.getUsername());
         _user.setPhone(user.getPhone());
          _user.setAddress(user.getAddress());
         _user.setBirthDay(user.getBirthDay());
         _user.setCivil_status(user.getCivil_status());
         _user.setFirstName(user.getFirstName());
         _user.setLastName(user.getLastName());
         _user.setProfil(user.getProfil());
     }else{
         _user.setEmail(user.getEmail());
         _user.setUsername(user.getUsername());
         _user.setPhone(user.getPhone());
         _user.setPassword(encoder.encode(user.getPassword()));
         _user.setAddress(user.getAddress());
         _user.setBirthDay(user.getBirthDay());
         _user.setCivil_status(user.getCivil_status());
         _user.setFirstName(user.getFirstName());
         _user.setLastName(user.getLastName());
         _user.setProfil(user.getProfil());
     }

        return userRepository.save(_user);
    }

    @Override
    public User aboutMe(Long id, String aboutMe) throws ResourceNotFoundException {

        Optional<User> user=userRepository.findById(id);
        User _user=user.get();
        _user.setAboutme(aboutMe);
        userRepository.save(_user);
        return _user;

    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
