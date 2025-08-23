package org.example.daos;

import org.example.entities.Student;
import org.hibernate.Session;

public class StudentDao extends GenericDao<Student, Long> {
    private final Session session;

    public StudentDao(Session session) {
        super(session, Student.class);
        this.session = session;
    }


}