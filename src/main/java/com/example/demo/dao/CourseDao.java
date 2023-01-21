package com.example.demo.dao;

import jakarta.persistence.EntityManager;

public class CourseDao {

    private Integer id;
    private String title;
    private Integer teacher_id;

    public CourseDao() {
    }

    public CourseDao(Integer id, String title, Integer teacher_id) {
        this.id = id;
        this.title = title;
        this.teacher_id = teacher_id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }
}