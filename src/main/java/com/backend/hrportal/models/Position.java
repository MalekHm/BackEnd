package com.backend.hrportal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String stafing_request;
    String open_expatriation;

    String description;

    String company;

    Date assignement_date ;

    public Position(String stafing_request,
                    String open_expatriation,
                    String description,String company,
                    Date assignement_date){

        this.stafing_request=stafing_request;
        this.open_expatriation=open_expatriation;
        this.description=description;
        this.company=company;
        this.assignement_date=assignement_date;

    }
}
