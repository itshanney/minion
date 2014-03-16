package net.hanney.minion.dao;

import net.hanney.minion.model.ServerType;
import org.springframework.stereotype.Repository;

/**
 * DAO that exposes CRUD functionality for working with {@link net.hanney.minion.model.ServerType}s
 *
 * @author justin.hanney
 */
@Repository(value = "serverTypesDao")
public class ServerTypesDao extends AbstractDao<ServerType> {

}
