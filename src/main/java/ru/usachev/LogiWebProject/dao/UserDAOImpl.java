package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addNewEmployee(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("from Employee where login=:login", User.class)
                .setParameter("login", login)
                .getSingleResult();
        return user;
    }

    @Override
    public List<User> getAllAdminUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users =  session.createQuery("from User", User.class)
                .getResultList();
        return users;
    }
}
