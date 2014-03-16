package net.hanney.minion.dao;

import net.hanney.minion.model.DataCenter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integrations tests for the {@link net.hanney.minion.dao.DataCentersDao} that
 * connect to a real database (running on localhost).
 *
 * @author justin.hanney
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context-localhost.xml"})
public class DataCentersDaoIT {

    @Autowired
    private DataCentersDao dataCentersDao;

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testCreateDataCenter() {
        final DataCenter dataCenter = new DataCenter();
        dataCenter.setDataCenterId("TESTDC");
        dataCenter.setDataCenterName("Test Data Center");
        dataCenter.setCreateDate(new DateTime(DateTimeZone.UTC).toDate());

        dataCentersDao.insert(dataCenter);
        dataCentersDao.delete(dataCenter);
    }

}
