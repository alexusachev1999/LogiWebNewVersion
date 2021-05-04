package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.entity.User;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

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
}
