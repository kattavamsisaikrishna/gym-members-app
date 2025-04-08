package com.example.gymapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="gym_members")
public class GymMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    @Column(name="membership_type")
    private String membershipType;

    @Column(name="join_date")
    private LocalDate joinDate;

    public GymMember() {}

    public GymMember(int id, LocalDate joinDate, String membershipType, String name, Integer age) {
        this.id = id;
        this.joinDate = joinDate;
        this.membershipType = membershipType;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
