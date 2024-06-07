package com.orm.hibernate_jpa;

import com.orm.hibernate_jpa.dao.StudentDAO;
import com.orm.hibernate_jpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> createStudent(studentDAO);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("creating new student object...");
		Student student = new Student("tom", "cruise", "sammy@mail.com");

		System.out.println("saving the student...");
		studentDAO.save(student);

		System.out.println("saved student. generated id: " + student.getId());
	}

}
