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
public class Remote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String comment;
    Date start;
    Date end;
    Boolean valide =false;

    Date registrationDate;

    @JsonIgnoreProperties("remotes")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
    public Remote(Date start,Date end,String comment){
        this.comment=comment;
        this.start=start;
        this.end=end;
        this.registrationDate=new Date(System.currentTimeMillis());
    }

}
