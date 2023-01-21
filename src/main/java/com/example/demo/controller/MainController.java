package com.example.demo.controller;

import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.repository.TeacherRepository;
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
    TeacherRepository teacherRepository;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "ok";
    }

    @PostMapping("/insertTeacher")
    public TeacherEntity insertTeacher(@RequestBody TeacherDao teacherDao){
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName(teacherDao.getName());
        teacherEntity.setAge(teacherDao.getAge());
        teacherEntity.setMajor(teacherDao.getMajor());
        teacherRepository.save(teacherEntity);
        log.info("insert teacher id={}",teacherEntity.getId());
        return teacherEntity;
    }

    @GetMapping("/getAllTeacher")
    public List<TeacherEntity> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @GetMapping("/getTeacher")
    public Optional<TeacherEntity> getTeacher(@RequestParam("id") Integer id) {
        log.info("get teacher id={}",id);
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(id);
        return teacherEntity;
    }

    @PutMapping("/updateTeacher")
    public TeacherEntity updateTeacher(@RequestBody TeacherDao teacherDao) {
        log.info("update teacher id={}", teacherDao.getId());
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(teacherDao.getId());
        TeacherEntity existTeacher = null;
        if (teacherEntity.isPresent()) {
            log.info("teacher exist");
            existTeacher = teacherEntity.get();
            existTeacher.setName(teacherDao.getName());
            existTeacher.setAge(teacherDao.getAge());
            existTeacher.setMajor(teacherDao.getMajor());
        }
        return teacherRepository.save(existTeacher);
    }

    @DeleteMapping("/deleteTeacher")
    public String deleteTeacher(@RequestBody TeacherDao teacherDao) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(teacherDao.getId());
        if (teacherEntity.isPresent()) {
            log.info("teacher exist, so delete!");
            teacherRepository.delete(teacherEntity.get());
            return "deleted";
        }
        return "teacher not exist";
    }
}
