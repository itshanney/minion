package net.hanney.minion.dao;

import net.hanney.minion.model.ServerVolume;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO that provides CRUD operations for {@link ServerVolume} obkects
 *
 * @author justin.hanney
 */
@Repository
public class ServerVolumesDao extends AbstractDao<ServerVolume> {

    public List<ServerVolume> selectActiveServerVolumesByServerId(final Long serverId) {
        LOG.debug("Selecting All Active Server Volumes for Server: {}", serverId);
        final List<ServerVolume> volumes = new LinkedList<ServerVolume>();
        final List dbVolumes = getCurrentSession().createCriteria(ServerVolume.class)
                .add(Restrictions.eq("serverId", serverId))
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .addOrder(Order.asc("mountPoint"))
                .list();
        for(Object type : dbVolumes) {
            volumes.add((ServerVolume) type);
        }

        return volumes;
    }
}
