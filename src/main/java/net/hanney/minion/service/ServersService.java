package net.hanney.minion.service;

import net.hanney.minion.dao.OperatingSystemsDao;
import net.hanney.minion.dao.ServerTypesDao;
import net.hanney.minion.dao.ServerVolumesDao;
import net.hanney.minion.dao.ServersDao;
import net.hanney.minion.model.OperatingSystem;
import net.hanney.minion.model.Server;
import net.hanney.minion.model.ServerState;
import net.hanney.minion.model.ServerType;
import net.hanney.minion.model.ServerVolume;
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
    private OperatingSystemsDao operatingSystemsDao;
    @Autowired
    private ServersDao serversDao;
    @Autowired
    private ServerTypesDao serverTypesDao;
    @Autowired
    private ServerVolumesDao serverVolumesDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOperatingSystem(final OperatingSystem operatingSystem) {
        operatingSystem.setCreateDate(new DateTime().toDate());
        operatingSystem.setIsActive(Boolean.TRUE);
        LOG.debug("Creating new Operating System: {}", operatingSystem);
        operatingSystemsDao.insert(operatingSystem);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createServer(final Server server) {
        server.setServerState(ServerState.ACTIVE);
        server.setCreateDate(new DateTime().toDate());
        server.setIsActive(Boolean.TRUE);
        LOG.debug("Creating new Server: {}", server);
        serversDao.insert(server);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createServerType(final ServerType serverType) {
        serverType.setCreateDate(new DateTime().toDate());
        serverType.setIsActive(Boolean.TRUE);
        LOG.debug("Creating new Server Type: {}", serverType);
        serverTypesDao.insert(serverType);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createServerVolume(final ServerVolume serverVolume) {
        serverVolume.setCreateDate(new DateTime().toDate());
        serverVolume.setIsActive(Boolean.TRUE);
        LOG.debug("Creating new Server Volume: {}", serverVolume);
        serverVolumesDao.insert(serverVolume);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteServer(final Server server)
    {
        final Server record = getServer(server.getServerId());

        LOG.debug("Deleting Server: {}", server);
        serversDao.delete(record);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void editServer(final Server server) {
        final Server record = getServer(server.getServerId());

        server.setCreateDate(record.getCreateDate());
        server.setIsActive(record.getIsActive());

        LOG.debug("Editing Server: {}", server);
        serversDao.update(server);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void editServerType(final ServerType serverType) {
        LOG.debug("Editing Server Type: {}", serverType);
        serverTypesDao.update(serverType);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<OperatingSystem> getOperatingSystems() {
        LOG.debug("Getting all Operating Systems");
        return operatingSystemsDao.selectActiveOperatingSystems();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Server getServer(final Long serverId) {
        LOG.debug("Getting Server with ID: {}", serverId);
        return serversDao.selectServerById(serverId);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Server> getServers() {
        LOG.debug("Getting all Servers");
        return serversDao.selectServersWithState(ServerState.ACTIVE);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ServerType> getServerTypes() {
        LOG.debug("Getting all Server Types");
        return serverTypesDao.selectActiveServerTypes();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ServerType getServerType(final Integer typeId) {
        LOG.debug("Getting Server Type with ID: {}", typeId);
        return serverTypesDao.selectServerTypeById(typeId);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<ServerVolume> getServerVolumes(final Long serverId) {
        LOG.debug("Getting Server Volumes for Server ID: {}", serverId);
        return serverVolumesDao.selectActiveServerVolumesByServerId(serverId);
    }

}
