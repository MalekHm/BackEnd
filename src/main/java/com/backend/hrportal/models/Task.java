package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String  title;
    String  description;
    boolean status=false;
    Date registrationDate;
    @JsonIgnore
    @ManyToOne
    User user;
    public Task(String title,String comment){
        this.title=title;
         this.description=comment;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.registrationDate=new Date(System.currentTimeMillis());
    }
}

