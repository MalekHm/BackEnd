package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String subject;
    String description;
    String  status ="Pending";
    Date registrationDate;
    @JsonIgnoreProperties("requests")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    public Request(String subject,String description ){

        this.subject=subject;
        this.description=description;
        this.registrationDate=new Date(System.currentTimeMillis());

    }
}
