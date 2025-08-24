package org.example.daos;

import org.example.entities.Assignment;
import org.example.entities.Assignment;
import org.example.entities.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class AssignmentDao extends GenericDao<Assignment, Long> {
    private final Session session;

    public AssignmentDao(Session session) {
        super(session, Assignment.class);
        this.session = session;
    }
    public List<Assignment> findByCourse(Long courseId) {
        String query = "select a from Assignment a where a.course.id = :courseId";
        Query<Assignment> assignmentQuery = session.createQuery(query, Assignment.class);
        assignmentQuery.setParameter("teacherId", courseId);
        return assignmentQuery.getResultList();
    }

    public List<Assignment> findByDueDate(LocalDate dueDate) {
        String query = "select a from Assignment a where a.dueDate <= :dueDate";
        Query<Assignment> assignmentQuery = session.createQuery(query, Assignment.class);
        assignmentQuery.setParameter("dueDate", dueDate);
        return assignmentQuery.getResultList();
    }
    public List<Assignment> findAssignmentsByCourse(Long courseId) {
        String hql = "select a from Assignment a where a.course.id = :courseId";
        Query<Assignment> query = session.createQuery(hql, Assignment.class);
        query.setParameter("courseId", courseId);
        return query.getResultList();
    }

    public List<Assignment> findAssignmentsByDescription(String description) {
        String hql = "select a from Assignment a where a.description like :description";
        Query<Assignment> query = session.createQuery(hql, Assignment.class);
        query.setParameter("description", "%" + description + "%");
        return query.getResultList();
    }

    public List<Assignment> findAssignmentsByDescriptionAndDueDate(LocalDate dueDate) {
        String hql = "select a from Assignment a " + "where a.dueDate <= :dueDate";

        Query<Assignment> query = session.createQuery(hql, Assignment.class);
        query.setParameter("dueDate", dueDate);
        return query.getResultList();
    }


}
