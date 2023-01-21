package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dao.TeacherDAO;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.repository.TeacherRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    public static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    TeacherRepo teacherRepo;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "ok";
    }

    @PostMapping("/insertTeacher")
    public TeacherEntity insertTeacher(@RequestBody TeacherDAO teacherDao){
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName(teacherDao.getName());
        teacherEntity.setAge(teacherDao.getAge());
        teacherEntity.setMajor(teacherDao.getMajor());
        teacherRepo.save(teacherEntity);
        log.info("insert teacher id={}",teacherEntity.getId());
        return teacherEntity;
    }

    @GetMapping("/getAllTeacher")
    public List<TeacherEntity> getAllTeacher() {
        return teacherRepo.findAll();
    }

    @GetMapping("/getTeacher")
    public Optional<TeacherEntity> getTeacher(@RequestParam("id") Integer id) {
        log.info("get teacher id={}",id);
        Optional<TeacherEntity> teacherEntity = teacherRepo.findById(id);
        return teacherEntity;
    }

    @PutMapping("/updateTeacher")
    public TeacherEntity updateTeacher(@RequestBody TeacherDAO teacherDao) {
        log.info("update teacher id={}",teacherDao.getId());
        Optional<TeacherEntity> teacherEntity = teacherRepo.findById(teacherDao.getId());
        TeacherEntity existTeacher = null;
        if (teacherEntity.isPresent()) {
            log.info("teacher exist");
            existTeacher = teacherEntity.get();
            existTeacher.setName(teacherDao.getName());
            existTeacher.setAge(teacherDao.getAge());
            existTeacher.setMajor(teacherDao.getMajor());
        }
        return teacherRepo.save(existTeacher);
    }

    @DeleteMapping("/deleteTeacher")
    public String deleteTeacher(@RequestBody TeacherDAO teacherDao) {
        Optional<TeacherEntity> teacherEntity = teacherRepo.findById(teacherDao.getId());
        if (teacherEntity.isPresent()) {
            log.info("teacher exist, so delete!");
            teacherRepo.delete(teacherEntity.get());
            return "deleted";
        }
        return "teacher not exist";
    }
}
