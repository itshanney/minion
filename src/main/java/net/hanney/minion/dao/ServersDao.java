package net.hanney.minion.dao;

import net.hanney.minion.model.Server;
import net.hanney.minion.model.ServerState;
import org.hibernate.criterion.Order;
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

    public Server selectServerById(final Long serverId) {
        LOG.debug("Selecting Server by ID: {}", serverId);
        return (Server) getCurrentSession().get(Server.class, serverId);
    }

    public List<Server> selectServersWithState(final ServerState serverState) {
        LOG.debug("Selecting All Active Servers");
        final List<Server> servers = new LinkedList<Server>();
        final List types = getCurrentSession().createCriteria(Server.class)
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .add(Restrictions.eq("serverState", serverState))
                .addOrder(Order.asc("hostname"))
                .list();
        for(Object type : types) {
            servers.add((Server) type);
        }

        return servers;
    }
}
