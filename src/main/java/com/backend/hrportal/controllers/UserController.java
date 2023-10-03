package com.backend.hrportal.controllers;
import com.backend.hrportal.exception.ResourceNotFoundException;
import com.backend.hrportal.models.*;
import com.backend.hrportal.payload.request.DocumentRequest;
import com.backend.hrportal.payload.request.UploadUserImageRequest;
import com.backend.hrportal.repository.SkillsRepository;
import com.backend.hrportal.services.UserService;
import com.backend.hrportal.services.impl.UserServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
  private final UserServiceI userService;
  private final PasswordEncoder encoder;

  private final SkillsRepository skillsRepository;
  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllEmployees() {
     List users= userService.allUser();
    return ResponseEntity.ok().body(users);
  }
  @GetMapping("/user/{id}")
  public ResponseEntity<User>getSignle(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    User user = userService.findUser(id);
    return ResponseEntity.ok().body(user);
  }
  @GetMapping("/singleUser/{id}")
  public ResponseEntity<User>singleUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    User user = userService.findUser(id);
    return ResponseEntity.ok().body(user);
  }
  @PutMapping("/user/{id}")
  public ResponseEntity<User> updateUser(@PathVariable (value = "id") Long id,@RequestBody User user) throws ResourceNotFoundException{
    user.setPassword( user.getPassword());
    User _user=userService.updateUser(id,user);
    return ResponseEntity.ok().body(_user);
  }
  @DeleteMapping("/user/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable (value = "id") Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  @PostMapping ("/childRequest/{id}")
  public User childRequest(@PathVariable (value = "id") Long id, @RequestBody ChildRequest childRequest) throws ResourceNotFoundException {
    ChildRequest childRequest1=new ChildRequest(childRequest.getFirstName(),childRequest.getLastName(),
            childRequest.getAge(),childRequest.getComment());
   return userService.addChild(id,childRequest1);
  }

  @PostMapping ("/internetRequest/{id}")
  public User internetRequest(@PathVariable (value = "id") Long id, @RequestBody InternetRequest internetRequest) throws ResourceNotFoundException {
    InternetRequest internetRequest1=new InternetRequest(internetRequest.getName(),
            internetRequest.getStartDate(),
            internetRequest.getComment());
    return userService.addInternet(id,internetRequest1);
  }
  @PostMapping ("/gymRequest/{id}")
  public User gymRequest(@PathVariable (value = "id") Long id,@RequestBody GymRequest gymRequest) throws ResourceNotFoundException {
    GymRequest gymRequest1=new GymRequest(gymRequest.getName(),
            gymRequest.getStartDate(),
            gymRequest.getComment());

    System.out.println(gymRequest1.toString());

    return userService.addGym(id,gymRequest1);
  }
  @PostMapping ("/addHoliday/{id}")
  public User gymRequest(@PathVariable (value = "id") Long id,@RequestBody Holiday holiday) throws ResourceNotFoundException {
    Holiday holiday1=new Holiday(holiday.getStart(),holiday.getEnd(),holiday.getComment());
    return userService.addHoliday(id,holiday1);
  }
  @PostMapping ("/addPermission/{id}")
  public User addPermission(@PathVariable (value = "id") Long id,@RequestBody Permission permission) throws ResourceNotFoundException {
    Permission permission1=new Permission(permission.getStart(),permission.getEnd(),permission.getComment());
    return userService.addPermission(id,permission1);
  }
  @PostMapping ("/addRemote/{id}")
  public User addRemote(@PathVariable (value = "id") Long id,@RequestBody Remote remote) throws ResourceNotFoundException {
    Remote remote1=new Remote(remote.getStart(),remote.getEnd(),remote.getComment());
    return userService.addRemote(id,remote1);
  }
  @PostMapping ("/addPresence/{id}")
  public User addPresence(@PathVariable (value = "id") Long id,@RequestBody Presence presence) throws ResourceNotFoundException {
    Presence presence1=new Presence(presence.getStart(),presence.getEnd(),presence.getProject(),presence.getComment(),
           presence.getStartHour(),presence.getEndHour(),presence.getTotalHour() );
    return userService.addPresence(id,presence1);
  }
  @PostMapping ("/addSkills/{id}")
  public User addSkills(@PathVariable (value = "id") Long id,@RequestBody List<Skills> skills) throws ResourceNotFoundException {
    return userService.addSkills(id,skills);
  }

  @PostMapping ("/addEducation/{id}")
  public User addEducation(@PathVariable (value = "id") Long id,@RequestBody List<Education> educations) throws ResourceNotFoundException {
    return userService.addEducation(id,educations);
  }

  @PostMapping ("/addExperience/{id}")
  public User addExperience(@PathVariable (value = "id") Long id,@RequestBody List<Experience> experiences) throws ResourceNotFoundException {
    return userService.addExperience(id,experiences);
  }
  @PutMapping ("/aboutme/{id}")
  public User aboutme(@PathVariable (value = "id") Long id,@RequestBody  String aboutme) throws ResourceNotFoundException {
    return userService.aboutMe(id,aboutme);
  }
  @PutMapping ("/addTask/{id}")
  public User addTask(@PathVariable (value = "id") Long id,@RequestBody  Task task) throws ResourceNotFoundException {
    return userService.addTask(id,task);
  }
  @PutMapping ("/addRequest/{id}")
  public User addRequest(@PathVariable (value = "id") Long id,@RequestBody  Request request) throws ResourceNotFoundException {
    return userService.addRequest(id,request);
  }
  @GetMapping ("/search/{key}")
  public List<User> addRequest(@PathVariable (value = "key") String key)  {
    return userService.search(key);
  }

  @PostMapping ("/uploadAvatar")
  public User uploadAvatar(@ModelAttribute UploadUserImageRequest uploadUserImageRequest) throws ResourceNotFoundException {

    return userService.uploadAvatar(uploadUserImageRequest);
  }
  @GetMapping("/downloadFile/{filename:.+}")
  @ResponseBody
  public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws IOException {
    Resource file = userService.load(filename);
    Path path = file.getFile()
            .toPath();

    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
            .body(file);
  }
@DeleteMapping("/deleteSkills/{id}")
  public ResponseEntity<HttpStatus> deleteSkills(@PathVariable (value = "id") Long id){

    userService.deleteSkills(id);

  return new ResponseEntity<>(HttpStatus.ACCEPTED);
}

  @DeleteMapping("/deleteEducation/{id}")
  public ResponseEntity<HttpStatus> deleteEducation(@PathVariable (value = "id") Long id){

    userService.deleteEducation(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/deleteExperience/{id}")
  public ResponseEntity<HttpStatus> deleteExperience(@PathVariable (value = "id") Long id){

    userService.deleteExperience(id);

    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @GetMapping("/forgetPassword/{email}")
  public ResponseEntity<HttpStatus> forgetPassword(@PathVariable (value = "email") String email){
    userService.forgetPassword(email);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @GetMapping("/resetPassword/{token}/{password}")
  public ResponseEntity<HttpStatus> resetPassword(@PathVariable (value = "token") String token,
                                                  @PathVariable (value = "password") String password
                                                  ){
    userService.resetPassword(token,password);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

}
