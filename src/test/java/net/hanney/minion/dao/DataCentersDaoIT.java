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
 * @author hanney
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context.xml", "/dao-config.xml"})
public class DataCentersDaoIT {

    @Autowired
    private DataCentersDao dataCentersDao;

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testCreateDataCenter() {
        final DataCenter dataCenter = new DataCenter();
        dataCenter.setDataCenterId("SEA");
        dataCenter.setDataCenterName("Seattle Data Center");
        dataCenter.setCreateDate(new DateTime(DateTimeZone.UTC).toDate());

        dataCentersDao.createDataCenter(dataCenter);
        dataCentersDao.deleteDataCenter(dataCenter);
    }


}
