package net.hanney.minion.service;

import net.hanney.minion.dao.SslCertificatesDao;
import net.hanney.minion.dao.DataCentersDao;
import net.hanney.minion.dao.DomainsDao;
import net.hanney.minion.model.SslCertificate;
import net.hanney.minion.model.DataCenter;
import net.hanney.minion.model.Domain;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service that encapsulates the primary business logic behind all of the
 * networking-related aspects of server management.
 *
 * @author justin.hanney
 */
@Service
public class NetworkService {

    static final Logger LOG = LoggerFactory.getLogger(NetworkService.class);

    @Autowired
    private SslCertificatesDao sslCertificatesDao;
    @Autowired
    private DataCentersDao dataCentersDao;
    @Autowired
    private DomainsDao domainsDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createDataCenter(final DataCenter dataCenter) {
        dataCenter.setCreateDate(new DateTime().toDate());
        dataCenter.setIsActive(Boolean.TRUE);
        LOG.debug("Creating new Data Center: {}", dataCenter);
        dataCentersDao.insert(dataCenter);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createDomain(final Domain domain) {
        domain.setCreateDate(new DateTime().toDate());
        domain.setIsActive(Boolean.TRUE);
        LOG.debug("Creating new Domain: {}", domain);
        domainsDao.insert(domain);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createSslCertificate(final SslCertificate certificate) {
        certificate.setCreateDate(new DateTime().toDate());
        certificate.setIsActive(Boolean.TRUE);
        LOG.debug("Creating new SSL Certificate: {}", certificate);
        sslCertificatesDao.insert(certificate);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void editDataCenter(final DataCenter dataCenter) {
        LOG.debug("Editing Data Center: {}", dataCenter);
        dataCentersDao.update(dataCenter);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<SslCertificate> getActiveCertificates() {
        LOG.debug("Getting all Active Certificates");
        return sslCertificatesDao.selectActiveCertificates();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<DataCenter> getActiveDataCenters() {
        LOG.debug("Getting all Active Data Centers");
        return dataCentersDao.selectActiveServerTypes();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Domain> getActiveDomains() {
        LOG.debug("Getting all Active Domains");
        return domainsDao.selectActiveDomains();
    }

    @Transactional(propagation =  Propagation.REQUIRES_NEW)
    public DataCenter getDataCenter(final String dataCenterId) {
        LOG.debug("Getting Data Cetner with ID: {}", dataCenterId);
        return dataCentersDao.selectDataCenterById(dataCenterId);
    }

}
