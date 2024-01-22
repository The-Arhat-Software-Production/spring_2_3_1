package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    // интерфейс, который предоставляет API для взаимодействия с БД через JPA (Java Persistence API)
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User deleteUser(long id) throws NullPointerException {
        User user = readUser(id);
        if (user != null) {
            entityManager.remove(user);
            // принудительно применяет изменения к БД
            entityManager.flush();
            return user;
        } else {
            throw new NullPointerException("User with id " + id + " not found");
        }
    }

    @Override
    public List<User> listUsers() {
        // Создаем объект query, который представляет собой запрос JPA для выборки всех
        // записей из таблицы User и приведения результатов к типу User
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }
}
