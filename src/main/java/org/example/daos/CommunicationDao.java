package org.example.daos;

import org.example.entities.Communication;
import org.hibernate.Session;

public class CommunicationDao extends GenericDao<Communication, Long> {
    private final Session session;

    private CommunicationDao(Session session) {
        super(session, Communication.class);
        this.session = session;
    }
}
