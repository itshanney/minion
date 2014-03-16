package net.hanney.minion.dao;

import net.hanney.minion.model.OperatingSystem;
import org.springframework.stereotype.Repository;

/**
 * DAO that exposes CRUD functionality for working with {@link net.hanney.minion.model.OperatingSystem}s
 *
 * @author justin.hanney
 */
@Repository(value = "operatingSystemsDao")
public class OperatingSystemsDao extends AbstractDao<OperatingSystem> {

}
