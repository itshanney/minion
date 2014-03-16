package net.hanney.minion.dao;

import net.hanney.minion.model.DataCenter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author hanney
 */
@Repository(value = "dataCentersDao")
public class DataCentersDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void createDataCenter(final DataCenter dataCenter) {
        getCurrentSession().save(dataCenter);
    }

    public void deleteDataCenter(final DataCenter dataCenter) {
        getCurrentSession().delete(dataCenter);
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
