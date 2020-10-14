package com.dimetulugar.entities;

import javax.persistence.*;

@Entity
public class Beach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flag;

    private Long surge;

    private String landType;

    private Long dirt;

    private boolean nudist;

    private boolean pet;

    private Long amountOfPeople;

    private String access;

    private boolean handicapped;

    private String parking;

    @ManyToOne
    private Category category;

}
