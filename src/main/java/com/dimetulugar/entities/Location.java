package com.dimetulugar.entities;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String street;

    @Basic
    private String city;

    @Basic
    private String country;

    @Basic
    private String province;

    @Basic
    private String postalCode;

    @Basic
    private double longitude;

    @Basic
    private double latitude;
}
