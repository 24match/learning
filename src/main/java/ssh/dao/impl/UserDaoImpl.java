package ssh.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ssh.dao.UserDaoI;
import ssh.model.User;

import java.io.Serializable;

/**
 * @author
 * @date
 */
@Repository("userDao")
public class UserDaoImpl implements UserDaoI {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Serializable save(User user) {
        System.out.println("sessionFactory:[" + sessionFactory.getCurrentSession() + "]");
        return sessionFactory.getCurrentSession().save(user);
    }
}
