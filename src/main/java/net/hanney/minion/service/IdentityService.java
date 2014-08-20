package net.hanney.minion.service;

import net.hanney.minion.dao.UsersDao;
import net.hanney.minion.model.User;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
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

    private final PasswordEncryptor passwordEncryptor;

    @Autowired
    private UsersDao usersDao;

    public IdentityService() {
        passwordEncryptor = new StrongPasswordEncryptor();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User authenticateUser(final String email,
                                 final String password) throws AuthenticationException {
        final User user = getUserByEmail(email);

        if(passwordEncryptor.checkPassword(password, user.getPassword())) {
            return user;
        }

        throw new AuthenticationException("User is not authenticated");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User getUserByEmail(final String email) {
        LOG.debug("Getting User by Email: {}", email);
        return usersDao.selectUserByEmail(email);
    }

}
