package org.example.daos;

import org.example.entities.Student;
import org.example.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao extends GenericDao<Student, Long> {
    private final Session session;

    public StudentDao(Session session) {
        super(session, Student.class);
        this.session = session;
    }

    public List<Student> findByFirstName (String firstName) {
        String query = "select * from students where first_name like :firstname";
        Query<Student> studentQuery = session.createNativeQuery(query, Student.class);
        studentQuery.setParameter("firstname", "%"+firstName+"%");
        return studentQuery.getResultList();
    }
    public List<Student> findByLastName (String lastname) {
        String query = "select * from students where last_name like :lastname";
        Query<Student> studentQuery = session.createNativeQuery(query, Student.class);
        studentQuery.setParameter("lastname", "%" +lastname+ "%");
        return studentQuery.getResultList();
    }

    public List<Student> findByCourse (Long courseId) {
        String query = "select s from Student s where s.course.id = :courseId";
        Query<Student> studentQuery = session.createQuery(query, Student.class);
        studentQuery.setParameter("courseId", courseId);
        return studentQuery.getResultList();
    }

}