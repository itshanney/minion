package net.hanney.minion.dao;

import net.hanney.minion.model.DnsRecord;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO that exposes CRUD functionality for working with {@link net.hanney.minion.model.DnsRecord}s
 *
 * @author justin.hanney
 */
@Repository("dnsRecordsDao")
public class DnsRecordsDao extends AbstractDao<DnsRecord> {

    static final Logger LOG = LoggerFactory.getLogger(SslCertificatesDao.class);

    public DnsRecord selectRecordById(final Long recordId) {
        LOG.debug("Selecting DNS Record by ID: {}", recordId);
        return (DnsRecord) getCurrentSession().get(DnsRecord.class, recordId);
    }

    public List<DnsRecord> selectActiveDnsRecords() {
        LOG.debug("Selecting all Active DNS Records");
        final List<DnsRecord> activeDnsRecords = new LinkedList<DnsRecord>();
        final List certs = getCurrentSession().createCriteria(DnsRecord.class)
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .addOrder(Order.asc("name"))
                .list();
        for(Object cert : certs) {
            activeDnsRecords.add((DnsRecord) cert);
        }

        return activeDnsRecords;
    }

}
