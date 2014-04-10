package net.hanney.minion.dao;

import net.hanney.minion.model.Domain;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * DAO that exposes CRUD functionality for working with {@link net.hanney.minion.model.Domain}s
 *
 * @author justin.hanney
 */
@Repository("domainsDao")
public class DomainsDao extends AbstractDao<Domain> {

    static final Logger LOG = LoggerFactory.getLogger(DomainsDao.class);

    public Domain selectDomainById(final Integer domainId) {
        LOG.debug("Selecting Domain by ID: {}", domainId);
        return (Domain) getCurrentSession().get(Domain.class, domainId);
    }

    public List<Domain> selectActiveDomains() {
        LOG.debug("Selecting all Active Domains");
        final List<Domain> activeDomains = new LinkedList<Domain>();
        final List domains = getCurrentSession().createCriteria(Domain.class)
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .list();
        for(Object domain : domains) {
            activeDomains.add((Domain) domain);
        }

        return activeDomains;
    }
}
