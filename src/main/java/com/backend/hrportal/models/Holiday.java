package com.backend.hrportal.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String comment;
    String start;
    String end;
    String  status ="Pending";
    Date registrationDate;



    @JsonIgnoreProperties("holidays")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    public Holiday(String start,String end,String description){
        this.comment=description;
        this.start=start;
        this.end=end;
        this.registrationDate=new Date(System.currentTimeMillis());
    }

}
