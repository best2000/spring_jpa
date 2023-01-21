package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher", schema = "school")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String major;

    public TeacherEntity() {
    }

    public TeacherEntity(Integer id, String name, Integer age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
