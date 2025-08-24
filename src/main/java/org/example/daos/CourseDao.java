package org.example.daos;

import jakarta.persistence.EntityManager;
import org.example.entities.Course;
import org.example.entities.Course;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDao extends GenericDao<Course, Long> {
    private final Session session;

    public CourseDao(Session session) {
        super(session, Course.class);
        this.session = session;
    }

    public List<Course> findByName(String name) {
        String query = "select * from students where name like :name";
        Query<Course> courseQuery = session.createNativeQuery(query, Course.class);
        courseQuery.setParameter("name", "%" + name + "%");
        return courseQuery.getResultList();
    }

    public List<Course> findByTeacher(Long teacherId) {
        String query = "select c from Course c where c.teacher.id = :teacherId";
        Query<Course> courseQuery = session.createQuery(query, Course.class);
        courseQuery.setParameter("teacherId", teacherId);
        return courseQuery.getResultList();
    }
}

