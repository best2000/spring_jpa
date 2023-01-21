package com.example.demo.service;

import com.example.demo.dao.CourseDao;
import com.example.demo.entity.CourseEntity;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public CourseEntity insertCourse(CourseDao courseDao) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setTitle(courseDao.getTitle());
        courseEntity.setTeacher_id(courseDao.getTeacher_id());
        return courseRepository.save(courseEntity);
    }

}
