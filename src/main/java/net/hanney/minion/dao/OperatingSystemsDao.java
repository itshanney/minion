package net.hanney.minion.dao;

import net.hanney.minion.model.OperatingSystem;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO that exposes CRUD functionality for working with {@link net.hanney.minion.model.OperatingSystem}s
 *
 * @author justin.hanney
 */
@Repository(value = "operatingSystemsDao")
public class OperatingSystemsDao extends AbstractDao<OperatingSystem> {

    static final Logger LOG = LoggerFactory.getLogger(OperatingSystemsDao.class);

    public OperatingSystem selectOperatingSystemById(final Integer operatingSystemId) {
        LOG.debug("Selecting OperatingSystem by ID: {}",  operatingSystemId);
        return (OperatingSystem) getCurrentSession().get(OperatingSystem.class, operatingSystemId);
    }

    public List<OperatingSystem> selectActiveOperatingSystems() {
        LOG.debug("Selecting All Active OperatingSystems");
        final List<OperatingSystem> operatingSystems = new LinkedList<OperatingSystem>();
        final List types = getCurrentSession().createCriteria(OperatingSystem.class)
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .list();
        for(Object type : types) {
            operatingSystems.add((OperatingSystem) type);
        }

        return operatingSystems;
    }

}
