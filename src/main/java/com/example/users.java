package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "usir")
public class users {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id",referencedColumnName = "id")
    private profile Profile;

//    constructors

    public users() {}

    public users(String name,profile Profile) {
        this.name = name;
        this.Profile = Profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public profile getProfile() {
        return Profile;
    }

    public void setProfile(profile profile) {
        Profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
