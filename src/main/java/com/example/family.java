package com.example;


import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "member.Findall",
                query = "FROM family"
        ),
        @NamedQuery(
                name = "person.Findbyname",
                query = "FROM family f WHERE f.name = :name"
        ),
        @NamedQuery(
                name = "id.Findbyid",
                query = "FROM family f WHERE f.id = :id"
        )
})
public class family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int member;

    public family () {}

    public family (String name,int member) {
        this.name = name;
        this.member = member;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }


    @Override
    public String toString() {
        return "family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", member=" + member +
                '}';
    }
}
