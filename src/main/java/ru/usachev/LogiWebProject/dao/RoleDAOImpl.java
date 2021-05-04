package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.entity.Authority;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Authority getRoleById(int roleId) {
        Session session = sessionFactory.getCurrentSession();
        Authority authority = session.get(Authority.class, roleId);
        return authority;
    }
}
