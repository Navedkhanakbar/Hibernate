package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String gender;

    @ManyToOne
    @JoinColumn(name = "Child_id")
    private Children children;

    // constructor

    public Parent () {}

    public Parent(String gender,Children children) {
        this.gender = gender;
        this.children = children;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", children=" + children +
                '}';
    }
}
