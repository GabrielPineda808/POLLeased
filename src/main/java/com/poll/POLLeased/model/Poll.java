package com.poll.POLLeased.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    //jpa creates separate table in db that takes the poll id and this options list as columns and data
    //using id as a foreign key pointing ot poll id and do this to have them related without making a new model
    @ElementCollection
    private List<String> options = new ArrayList<>();

    @ElementCollection
    private List<String> votes = new ArrayList<>();

}
