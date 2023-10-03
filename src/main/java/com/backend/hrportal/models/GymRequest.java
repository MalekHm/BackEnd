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
public class GymRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    Date startDate;
    String comment;
    Date registrationDate;
    public GymRequest(String name,Date startDate,String comment){

        this.name=name;
        this.startDate=startDate;
        this.comment=comment;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.registrationDate=new Date(System.currentTimeMillis());
    }
}
