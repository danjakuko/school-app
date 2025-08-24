package org.example.daos;

import org.example.entities.Communication;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class CommunicationDao extends GenericDao<Communication, Long> {
    private final Session session;

    private CommunicationDao(Session session) {
        super(session, Communication.class);
        this.session = session;
    }
    public List<Communication> findByTeacher (Long teacherId){
        String query = "select c from Communication c where c.teacher.id = :teacherId";
        Query<Communication> findQuery = session.createQuery(query);
        findQuery.setParameter("teacherId", teacherId);
        return findQuery.getResultList();
    }
    public List<Communication> findByStudent (Long studentId) {
        String query = "select c from communication c where c.student.id = :studentId";
        Query<Communication> findQuery = session.createQuery(query);
        findQuery.setParameter("studentId", studentId);
        return findQuery.getResultList();
    }
    public List<Communication> findByText (String text) {
        String query = "select c from communication c where c.message like :text ";
        Query<Communication> findQuery = session.createQuery(query);
        findQuery.setParameter("text", "%"+ text+ "%");
        return findQuery.getResultList();
    }
    public List<Communication> findBySentDate (LocalDate sentDate) {
        String query = "selecet c from communication c where c.sentDate = :sentDate";
        Query<Communication> findQuery = session.createQuery(query);
        findQuery.setParameter("sentDate", sentDate);
        return findQuery.getResultList();
    }




}
