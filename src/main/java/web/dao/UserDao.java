package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   // CREATE
   void createUser(User user);
   // READ
   User readUser(long id);
   // UPDATE
   void updateUser(User user);
   // DELETE
   User deleteUser(long id);
   // View all users
   List<User> listUsers();

}
