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
public class Presence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date start;
    Date end;
    String comment;
    float startHour;
    float endHour;
    String project;
    Integer totalHour;
   Date registrationDate;
    @JsonIgnoreProperties("holidays")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    public Presence(
                    Date start,
                    Date end,
                    String project,
                    String comment,
                    float startHour,
                    float endHour,
                    Integer totalHour
    ) {
        this.start = start;
        this.end = end;
        this.project = project;
        this.comment = comment;
        this.startHour = startHour;
        this.endHour = endHour;
        this.totalHour = totalHour;
        this.registrationDate=new Date(System.currentTimeMillis());
    }
}
