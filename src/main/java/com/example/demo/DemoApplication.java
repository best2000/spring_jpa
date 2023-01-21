package com.example.demo;

import com.example.demo.entity.CourseEntity;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	CourseRepository courseRepository;

	public static Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("insert mock data to table...");
		// Inserting the data in table.
		TeacherEntity teacher1 = new TeacherEntity(1,"Thestui Supato",99,"Computer Engineering");
		TeacherEntity teacher2 = new TeacherEntity(2,"Jonathan Joestar",50,"Hamon man");
		TeacherEntity teacher3 = new TeacherEntity(3,"Hand Solo",41,"Handjob");
		teacherRepository.save(teacher1);
		teacherRepository.save(teacher2);
		teacherRepository.save(teacher3);
		CourseEntity course1 = new CourseEntity(1,"How to fuck",1);
		CourseEntity course2 = new CourseEntity(2,"How to Fap",1);
		CourseEntity course3 = new CourseEntity(3,"Hamon nastery",2);
		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		log.info("insert mock data done.");
	}
}
