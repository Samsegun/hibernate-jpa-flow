package com.orm.hibernate_jpa.dao;

import com.orm.hibernate_jpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String studentLastName);
    void update(Student student);
    void delete(Integer id);
    int deleteAll();
}
