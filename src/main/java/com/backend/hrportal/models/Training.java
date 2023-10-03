package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String domain;
    String theme;
    String duration;
    String unit;

    String description;

    String type;
    String target;
    Boolean certification;
    String pre_requires;
    Date startDate;
    Date endDate;

    String evualuation;
    Boolean completed=false;



    public  Training(String domain,String theme,String duration,String unit,String description
                     ,String type,String target,
                     Boolean certification,String pre_requires,Date startDate,Date endDate){
        this.domain=domain;
        this.theme=theme;
        this.duration=duration;
         this.unit=unit;
         this.description=description;

        this.type=type;
        this.target=target;
        this.certification=certification;
        this.pre_requires=pre_requires;
        this.startDate=startDate;
        this.endDate=endDate;
    }
}
