package com.backend.hrportal.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChildRequest{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String firstName;
    Long age;
    String lastName;
    String comment;
    Date registrationDate;

    public ChildRequest(String firstName,String lastName,Long age,String comment){

        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.comment=comment;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.registrationDate=new Date(System.currentTimeMillis());
    }
}

