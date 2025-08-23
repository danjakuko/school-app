package org.example.daos;

import org.example.entities.Assignment;
import org.example.entities.Assignment;
import org.hibernate.Session;

public class AssignmentDao extends GenericDao<Assignment, Long> {
    private final Session session;

    public AssignmentDao(Session session) {
        super(session, Assignment.class);
        this.session = session;
    }


}
