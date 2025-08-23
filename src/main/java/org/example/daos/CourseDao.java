package org.example.daos;

import org.example.entities.Course;
import org.example.entities.Course;
import org.hibernate.Session;

public class CourseDao extends GenericDao<Course, Long> {
    private final Session session;

    public CourseDao(Session session) {
        super(session, Course.class);
        this.session = session;
    }


}
