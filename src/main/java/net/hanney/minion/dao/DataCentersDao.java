package net.hanney.minion.dao;

import net.hanney.minion.model.DataCenter;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO that exposes CRUD functionality for working with {@link DataCenter}s
 *
 * @author justin.hanney
 */
@Repository(value = "dataCentersDao")
public class DataCentersDao extends AbstractDao<DataCenter> {

    static final Logger LOG = LoggerFactory.getLogger(DataCentersDao.class);

    public DataCenter selectDataCenterById(final String dataCenterId) {
        LOG.debug("Selecting DataCenter by ID: {}",  dataCenterId);
        return (DataCenter) getCurrentSession().get(DataCenter.class, dataCenterId);
    }

    public List<DataCenter> selectActiveServerTypes() {
        LOG.debug("Selecting All Active ServerTypes");
        final List<DataCenter> dataCenters = new LinkedList<DataCenter>();
        final List types = getCurrentSession().createCriteria(DataCenter.class)
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .list();
        for(Object type : types) {
            dataCenters.add((DataCenter) type);
        }

        return dataCenters;
    }

}
