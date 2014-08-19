package net.hanney.minion.service;

import net.hanney.minion.dao.UsersDao;
import net.hanney.minion.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service that handles Identity-related activities for {@link User}s
 * </p>
 * Common functions related to Identity include:
 * <ul>
 *     <li>Authenticating a user with credentials</li>
 *     <li>Getting User details</li>
 * </ul>
 *
 * @author justin.hanney
 */
@Service
public class IdentityService {

    static final Logger LOG = LoggerFactory.getLogger(IdentityService.class);

    @Autowired
    private UsersDao usersDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User getUserById(final Long userId) {
        LOG.debug("Getting User By ID: {}", userId);
        return usersDao.selectUserById(userId);
    }

}
