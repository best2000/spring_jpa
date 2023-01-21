package com.example.demo.repository;

import com.example.demo.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherEntity,Integer> {

}
