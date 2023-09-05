package com.backend.hrportal.models;

import lombok.AllArgsConstructor;
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
    Long duration;
    Long month;
    String nature;
    String workingCalendar;
    Date startDate;

    Date endDate;

      Date expectedEndDate;
    Long employePeriode1;
    Long employePeriode2;
    @OneToOne
    User user;
    @OneToOne
    User manager;
}
