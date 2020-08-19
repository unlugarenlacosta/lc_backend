package com.unlugarenlacosta.entities;

import javax.persistence.*;

@Entity
public class Commentary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String description;

    @ManyToOne
    private User user;
}
