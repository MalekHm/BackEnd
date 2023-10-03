package com.backend.hrportal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    User user;

    @OneToOne
    Training training;

    Date requestDate;
    String status ="Pending";


    public TrainingRequest(User user,Training training){
        this.user=user;
        this.training=training;

        this.requestDate=new Date(System.currentTimeMillis());
    }

}
