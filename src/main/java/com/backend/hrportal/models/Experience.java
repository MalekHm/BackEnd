package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     String employer;

     String jobDescription;

    String jobTitle;
    Date startDate;
    Integer experience;
    @JsonIgnore
    @ManyToOne
    User user;
    public Experience(String title,String description,String company,Integer experience,Date startDate){

        this.jobTitle=title;
        this.jobDescription=description;
        this.employer=company;
        this.experience=experience;
        this.startDate=startDate;
    }
}
