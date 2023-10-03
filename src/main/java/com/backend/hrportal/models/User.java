package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  @Size(max = 20)
  private String username;
  private String firstName;
  private String lastName;
  private String address;

  private Date birthDay;
  private String civil_status;

  private String profil;
  private String profilImage;

  private String aboutme;

  private Long phone;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;


  @OneToMany
  List<ChildRequest> childRequestList ;
  @OneToMany
  List<InternetRequest> internetRequests = new ArrayList<>();
  @OneToMany
  List<GymRequest> gymRequests = new ArrayList<>();
  @OneToMany(mappedBy="user")
  List<Education> educations= new ArrayList<>();
  @OneToMany(mappedBy="user")
  List<Task> tasks= new ArrayList<>();
  @OneToMany
  List<Training> trainings= new ArrayList<>();
  @OneToMany(mappedBy="user")
  List<Skills> skills= new ArrayList<>();
  @OneToMany(mappedBy="user")
  List<Experience> experiences = new ArrayList<>();

  @JsonIgnoreProperties("user")
  @OneToMany(mappedBy = "user",
          cascade = CascadeType.PERSIST,
          orphanRemoval = true)
  List<Permission> permissions = new ArrayList<>();


  @JsonIgnoreProperties("user")
  @OneToMany(mappedBy = "user",
          cascade = CascadeType.PERSIST,
          orphanRemoval = true)
  List<Remote> remotes = new ArrayList<>();
  @JsonIgnoreProperties("user")
  @OneToMany(mappedBy = "user",
          cascade = CascadeType.PERSIST,
          orphanRemoval = true)
    List<Holiday> holidays ;
  @JsonIgnoreProperties("user")
  @OneToMany(mappedBy = "user",
          cascade = CascadeType.PERSIST,
          orphanRemoval = true)
  List<Presence> presences ;

  @JsonIgnoreProperties("user")
  @OneToMany(mappedBy = "user",
          cascade = CascadeType.PERSIST,
          orphanRemoval = true)
  List<Request> requests = new ArrayList<>();
  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();


  String token;
public User(String username,String firstName,String lastName,String address,
              Date birthDay,String civil_status,Long phone,String email,String password)
{
  this.username=username;
  this.email=email;
  this.firstName=firstName;
  this.lastName=lastName;
  this.address=address;
  this.birthDay=birthDay;
  this.civil_status=civil_status;
  this.phone=phone;
  this.password=password;
}
  public User(String username,String email,String password)
  {
    this.username=username;
this.email=email;
    this.password=password;
  }


}
