package com.example.demo.controller;

import com.example.demo.dao.TeacherDAO;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    TeacherRepo teacherRepo;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "ok";
    }

    @PostMapping("/saveTeacher")
    public TeacherEntity saveTeacher(@RequestBody TeacherDAO teacherDao){
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName(teacherDao.getName());
        teacherEntity.setAge(teacherDao.getAge());
        teacherEntity.setMajor(teacherDao.getMajor());
        teacherRepo.save(teacherEntity);
        return teacherEntity;
    }
}
