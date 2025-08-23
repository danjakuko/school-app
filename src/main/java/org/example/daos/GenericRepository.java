package org.example.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public abstract class GenericRepository<T, ID> {
    private final Session session;
    private final Class<T> aClass;

    public GenericRepository(Session session, Class<T> aClass) {
        this.session = session;
        this.aClass = aClass;
    }
    public T save(T t){
        Transaction transaction = session.beginTransaction();
        try {
            T savedEntity = session.merge(t);
            transaction.commit();
            return savedEntity;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }

    public List<T> findAll(){
        String query = "select r from "+aClass.getSimpleName()+" r";
        Query<T> findAllQuery = session.createQuery(query, aClass);
        return findAllQuery.getResultList();
    }

    public T findById(ID id){
        return session.find(aClass, id);
    }
    public void delete(ID id){
        T entity = this.findById(id);
        session.remove(entity);
    }
}
