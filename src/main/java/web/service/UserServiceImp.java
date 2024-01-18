package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    // CREATE
    @Transactional
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    // READ
    @Transactional(readOnly = true)
    @Override
    public User readUser(long id) {
        return userDao.readUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public User deleteUser(long id) {
        return userDao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
