package net.hanney.minion.service;

import net.hanney.minion.dao.DataCentersDao;
import net.hanney.minion.model.DataCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service that encapsulates the primary business logic behind all of the configuration
 * aspects of Minion, including Server Types, Data Centers, etc.
 *
 * @author justin.hanney
 */
@Service
public class NimdaService {

    @Autowired
    private DataCentersDao dataCentersDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public DataCenter createDataCenter(final DataCenter dataCenter) {
        dataCentersDao.insert(dataCenter);
        return dataCenter;
    }

}
