package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Embedded
    private Address address;


    @Transient
     private int age;


    public User() {}

    public User(String name,String email) {
        this.name = name;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + email +
                " | Address: " + address.getStreet() + ", " +
                address.getCity() + ", " +
                address.getState() + " - " +
                address.getZipcode();
    }
}
