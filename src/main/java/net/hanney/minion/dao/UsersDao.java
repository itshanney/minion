package net.hanney.minion.dao;

import net.hanney.minion.model.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * DAO that handles CRUD interactions with the {@link User} model
 *
 * @author justin.hanney
 */
@Repository
public class UsersDao extends AbstractDao<User> {

    public User selectUserByEmail(final String email) {
        LOG.debug("Selecting User by Email: {}", email);
        return (User) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("isActive", Boolean.TRUE))
                .uniqueResult();
    }

}
