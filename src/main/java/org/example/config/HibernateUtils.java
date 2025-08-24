package org.example.config;

import org.example.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Assignment.class);
            configuration.addAnnotatedClass(Communication.class);
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(AbstractEntity.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
