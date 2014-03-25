package net.hanney.minion.service;

import net.hanney.minion.dao.ServerTypesDao;
import net.hanney.minion.model.ServerType;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service that encapsulates all of the functionality that relates to administering
 * Servers and any associated metadata attached to them.
 *
 * @author justin.hanney
 */
@Service
public class ServersService {

    static final Logger LOG = LoggerFactory.getLogger(ServersService.class);

    @Autowired
    private ServerTypesDao serverTypesDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createServerType(final ServerType serverType) {
        serverType.setCreateDate(new DateTime().toDate());
        serverType.setIsActive(Boolean.TRUE);
        LOG.debug("Creating new Server Type: {}", serverType);
        serverTypesDao.insert(serverType);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void editServerType(final ServerType serverType) {
        LOG.debug("Editing Server Type: {}", serverType);
        serverTypesDao.update(serverType);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ServerType> getActiveServerTypes() {
        LOG.debug("Getting all Active Server Types");
        return serverTypesDao.selectActiveServerTypes();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ServerType getServerType(final String typeId) {
        LOG.debug("Getting Server Type with ID: {}", typeId);
        return serverTypesDao.selectServerTypeById(typeId);
    }

}
