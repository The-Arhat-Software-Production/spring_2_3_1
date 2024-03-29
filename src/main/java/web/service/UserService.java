package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User readUser(long id);

    void updateUser(User user);

    User deleteUser(long id);

    List<User> listUsers();

}
