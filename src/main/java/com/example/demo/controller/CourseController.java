package com.example.demo.controller;

import com.example.demo.dao.CourseDao;
import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.CourseEntity;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;


    @PostMapping("/insertCourse")
    public CourseEntity insertCourse(@RequestBody CourseDao courseDao){
        return  courseService.insertCourse(courseDao);
    }
}
