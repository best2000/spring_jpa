package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course", schema = "school")
public class CourseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String title;
        @Column(name="teacher_id")
        private Integer teacherId;

    public CourseEntity() {
    }

    public CourseEntity(Integer id, String title, Integer teacher_id) {
        this.id = id;
        this.title = title;
        this.teacherId = teacher_id;
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer teacherId() {
        return teacherId;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacherId = teacher_id;
    }
}
