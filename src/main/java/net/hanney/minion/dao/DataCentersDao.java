package net.hanney.minion.dao;

import net.hanney.minion.model.DataCenter;
import org.springframework.stereotype.Repository;

/**
 * DAO that exposes CRUD functionality for working with {@link DataCenter}s
 *
 * @author justin.hanney
 */
@Repository(value = "dataCentersDao")
public class DataCentersDao extends AbstractDao<DataCenter> {

}
