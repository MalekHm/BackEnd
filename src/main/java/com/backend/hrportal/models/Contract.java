package com.backend.hrportal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String type;
    String duration;
    String nature;
    String workingCalendar;
    Date startDate;
    Date endDate;
    @OneToOne
    User employee;

    public Contract(String type,User employee,String duration, String nature,String workingCalendar,Date startDate,
                    Date endDate  ){

        this.type=type;
        this.employee=employee;
        this.duration=duration;
        this.nature=nature;
        this.workingCalendar=workingCalendar;
        this.startDate=startDate;
        this.endDate=endDate;
    }
}
