package com.example.demo.repository;

import com.example.demo.dao.CourseDao;
import com.example.demo.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {

}
