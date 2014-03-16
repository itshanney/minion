package net.hanney.minion.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Abstract DAO that provides common CRUD functionality that's used across all DAOs
 *
 * @author justin.hanney
 */
public class AbstractDao<T extends Serializable> {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Deletes the supplied object in the database
     * @param model Object to delete
     */
    public void delete(final T model) {
        getCurrentSession().delete(model);
    }

    /**
     * Inserts the supplied object in the database
     * @param model Object to insert
     */
    public void insert(final T model) {
        getCurrentSession().save(model);
    }

    /**
     * Updates the supplied object in the database
     * @param model Object to update
     */
    public void update(final T model) {
        getCurrentSession().merge(model);
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
