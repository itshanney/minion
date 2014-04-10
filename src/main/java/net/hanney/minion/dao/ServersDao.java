package net.hanney.minion.dao;

import net.hanney.minion.model.Server;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO that exposes CRUD functionality for working with {@link Server}s.
 *
 * @author justin.hanney
 */
@Repository("serversDao")
public class ServersDao extends AbstractDao<Server> {

    static final Logger LOG = LoggerFactory.getLogger(ServersDao.class);

    public List<Server> selectActiveServers() {
        LOG.debug("Selecting All Active Servers");
        final List<Server> servers = new LinkedList<Server>();
        final List types = getCurrentSession().createCriteria(Server.class)
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .list();
        for(Object type : types) {
            servers.add((Server) type);
        }

        return servers;
    }
}
