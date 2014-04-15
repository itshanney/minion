package net.hanney.minion.dao;

import net.hanney.minion.model.SslCertificate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO that exposes CRUD functionality for working with {@link net.hanney.minion.model.SslCertificate}s
 *
 * @author justin.hanney
 */
@Repository("sslCertificatesDao")
public class SslCertificatesDao extends AbstractDao<SslCertificate> {

    static final Logger LOG = LoggerFactory.getLogger(SslCertificatesDao.class);

    public List<SslCertificate> selectActiveCertificates() {
        LOG.debug("Selecting all Active Certificates");
        final List<SslCertificate> activeSslCertificates = new LinkedList<SslCertificate>();
        final List certs = getCurrentSession().createCriteria(SslCertificate.class)
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .addOrder(Order.asc("certificateName"))
                .list();
        for(Object cert : certs) {
            activeSslCertificates.add((SslCertificate) cert);
        }

        return activeSslCertificates;
    }

}
