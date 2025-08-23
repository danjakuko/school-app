package org.example.daos;

import org.example.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherDao extends GenericDao<Teacher, Long> {
    private  final Session session;

    public TeacherDao (Session session) {
        super(session, Teacher.class);
        this.session = session;
    }

    public List<Teacher> findByFirstName (String first_name) {
        String query = "select * from teachers where first_name = :firstname";
        Query<Teacher> teacherQuery = session.createNativeQuery(query, Teacher.class);
        teacherQuery.setParameter("firstname", first_name);
        return teacherQuery.getResultList();
    }
    public List<Teacher> findByLastName (String lastname) {
        String query = "select * from teachers where last_name = :lastname";
        Query<Teacher> teacherQuery = session.createNativeQuery(query, Teacher.class);
        teacherQuery.setParameter("lastname", lastname);
        return teacherQuery.getResultList();
    }
    public Teacher findById (Long id) {
        return session.find(Teacher.class, id);
    }
    public List<Teacher> findBySubject (String subject) {

    }

}
