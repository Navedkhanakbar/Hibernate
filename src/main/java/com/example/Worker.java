package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "AKAslave")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "Age")
    private int age;


    @Column(name = "Name")
    private String name;


    @Column(name = "State")
    private String state;

    @Column(name = "Salary")
    private double salary;

    public Worker() {}

    public Worker (int age, String name,String state,double salary) {
        this.age = age;
        this.name = name;
        this.state = state;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", salary=" + salary +
                '}';
    }
}
