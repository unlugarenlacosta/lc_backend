package com.unlugarenlacosta.entities;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Destination{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Lob
    private String description;

    @Column
    @Lob
    private String information;

    @Basic
    private double assessment;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "destinations")
    private List<User> users = new ArrayList<>();

}
