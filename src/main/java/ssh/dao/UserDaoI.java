package ssh.dao;

import ssh.model.User;

import java.io.Serializable;

/**
 * @Author
 * @Date
 */
public interface UserDaoI {

    Serializable save(User user);
}
