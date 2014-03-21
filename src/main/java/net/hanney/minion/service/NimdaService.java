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
 * Service that encapsulates the primary business logic behind all of the configuration
 * aspects of Minion, including Server Types, Data Centers, etc.
 *
 * @author justin.hanney
 */
@Service
public class NimdaService {

    static final Logger LOG = LoggerFactory.getLogger(NimdaService.class);

    @Autowired
    private ServerTypesDao serverTypesDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createServerType(final ServerType serverType) {
        serverType.setCreateDate(new DateTime().toDate());
        serverType.setIsActive(Boolean.TRUE);
        LOG.debug("Inserting new ServerType: {}", serverType);
        serverTypesDao.insert(serverType);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void editServerType(final ServerType serverType) {
        LOG.debug("Editing ServerType: {}", serverType);
        serverTypesDao.update(serverType);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ServerType> getActiveServerTypes() {
        LOG.debug("Getting all Active Server Types");
        return serverTypesDao.selectActiveServerTypes();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ServerType getServerType(final String typeId) {
        LOG.debug("Getting ServerType with ID: {}", typeId);
        return serverTypesDao.selectServerTypeById(typeId);
    }

}
