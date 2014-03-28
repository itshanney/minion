package net.hanney.minion.dao;

import net.hanney.minion.model.ServerType;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO that exposes CRUD functionality for working with {@link net.hanney.minion.model.ServerType}s
 *
 * @author justin.hanney
 */
@Repository(value = "serverTypesDao")
public class ServerTypesDao extends AbstractDao<ServerType> {

    static final Logger LOG = LoggerFactory.getLogger(ServerTypesDao.class);

    public ServerType selectServerTypeById(final Integer typeId) {
        LOG.debug("Selecting ServerType by ID: {}",  typeId);
        return (ServerType) getCurrentSession().get(ServerType.class, typeId);
    }

    public List<ServerType> selectActiveServerTypes() {
        LOG.debug("Selecting All Active ServerTypes");
        final List<ServerType> serverTypes = new LinkedList<ServerType>();
        final List types = getCurrentSession().createCriteria(ServerType.class)
                .add(Restrictions.eq("isActive",  Boolean.TRUE))
                .list();
        for(Object type : types) {
            serverTypes.add((ServerType)type);
        }

        return serverTypes;
    }

}
