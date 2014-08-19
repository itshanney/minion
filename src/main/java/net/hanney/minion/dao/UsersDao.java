package net.hanney.minion.dao;

import net.hanney.minion.model.User;
import org.springframework.stereotype.Repository;

/**
 * DAO that handles CRUD interactions with the {@link User} model
 *
 * @author justin.hanney
 */
@Repository
public class UsersDao extends AbstractDao<User> {

    public User selectUserById(final Long userId) {
        LOG.debug("Selecting User by ID: {}", userId);
        return (User) getCurrentSession().get(User.class, userId);
    }
}
