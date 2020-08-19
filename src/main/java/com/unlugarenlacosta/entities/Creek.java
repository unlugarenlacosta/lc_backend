package com.unlugarenlacosta.entities;

import javax.persistence.*;

@Entity
public class Creek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long surge;

    private String typeOfCreek;

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
