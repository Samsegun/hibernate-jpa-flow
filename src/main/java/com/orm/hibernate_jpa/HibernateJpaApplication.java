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
        return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//          readAllStudents(studentDAO);
//          readStudentByLastName(studentDAO);
//          updateStudent(studentDAO);
//            removeStudent(studentDAO);
//            removeAllStudent(studentDAO);
        };
    }

    private void removeAllStudent(StudentDAO studentDAO) {
        System.out.println("deleting all students...");
        int rowsDeleted = studentDAO.deleteAll();

        System.out.println("Deleted rows count: " + rowsDeleted);
    }

    private void removeStudent(StudentDAO studentDAO) {
        System.out.println("deleting student...");
        studentDAO.delete(6);

        System.out.println("student deleted ");
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("updating student...");
        var student = studentDAO.findById(6);
        student.setLastName("doe");

        studentDAO.update(student);
        System.out.println("student updated " + student);
    }

    private void readStudentByLastName(StudentDAO studentDAO) {
        System.out.println("getting all students...");
        var students = studentDAO.findByLastName("keith");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readAllStudents(StudentDAO studentDAO) {
        System.out.println("getting all students...");
        var students = studentDAO.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("getting student by Id...");
        var student = studentDAO.findById(5);

        System.out.println(student);
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        System.out.println("creating 3 students...");
        Student student1 = new Student("john", "dow", "johnny@mail.com");
        Student student2 = new Student("jane", "scott", "jscott@mail.com");
        Student student3 = new Student("sam", "keith", "keithy@mail.com");

        System.out.println("saving the students...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("creating new student object...");
        Student student = new Student("tom", "cruise", "sammy@mail.com");

        System.out.println("saving the student...");
        studentDAO.save(student);

        System.out.println("saved student. generated id: " + student.getId());
    }

}
