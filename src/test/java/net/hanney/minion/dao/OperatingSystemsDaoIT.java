package net.hanney.minion.dao;

import net.hanney.minion.model.OperatingSystem;
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
 * Integrations tests for the {@link net.hanney.minion.dao.OperatingSystemsDao} that
 * connect to a real database (running on localhost).
 *
 * @author justin.hanney
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context-localhost.xml"})
public class OperatingSystemsDaoIT {

    @Autowired
    private OperatingSystemsDao operatingSystemsDao;

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testInsert() {
        final OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setOperatingSystemId("ub.12.04.lts");
        operatingSystem.setOperatingSystemName("Ubuntu 12.04 LTS");
        operatingSystem.setCreateDate(new DateTime(DateTimeZone.UTC).toDate());

        operatingSystemsDao.insert(operatingSystem);
        operatingSystemsDao.delete(operatingSystem);
    }

}
