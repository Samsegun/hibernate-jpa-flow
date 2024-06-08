package com.orm.hibernate_jpa.dao;

import com.orm.hibernate_jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //define entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student order by lastName desc", Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String studentLastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);

        //set query parameter
        theQuery.setParameter("theData", studentLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numOfRowsDeleted;

    }


}
