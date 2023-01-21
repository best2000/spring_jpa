package com.example.demo;

import com.example.demo.dao.TeacherDAO;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.repository.TeacherRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	TeacherRepo teacherRepo;

	public static Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("insert mock data to table...");
		// Inserting the data in table.
		TeacherEntity teacher1 = new TeacherEntity(0,"Thestha Subhatosha",22,"Computer Engineering");
		TeacherEntity teacher2 = new TeacherEntity(1,"Thestui Supato",99,"Computer Engineering");
		TeacherEntity teacher3 = new TeacherEntity(2,"Jonathan Joestar",50,"Hamon man");
		TeacherEntity teacher4 = new TeacherEntity(3,"Hand Solo",41,"Handjob");
		teacherRepo.save(teacher1);
		teacherRepo.save(teacher2);
		teacherRepo.save(teacher3);
		teacherRepo.save(teacher4);
		log.info("insert mock data done.");
	}
}
