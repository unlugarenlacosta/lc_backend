package com.dimetulugar.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Basic
    private String password;

    @Basic
    private boolean email_verify;

    @Basic
    private boolean isDeleted;

    @ManyToMany
    @JoinTable(
            name = "user_destination",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private List<Destination> destinations = new ArrayList<>();

    public User(){
        super();
    }

    public User(Long id, String username, String email, String password, boolean email_verify, boolean isDeleted, List<Destination> destinations) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.email_verify = email_verify;
        this.isDeleted = isDeleted;
        this.destinations = destinations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public boolean isEmail_verify() {
        return email_verify;
    }

    public void setEmail_verify(boolean email_verify) {
        this.email_verify = email_verify;
    }
}
