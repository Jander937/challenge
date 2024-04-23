package com.api.challenge.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class NoteBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img")
    private String img;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;
}
