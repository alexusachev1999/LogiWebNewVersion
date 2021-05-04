package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.dao.RoleDAO;
import ru.usachev.LogiWebProject.entity.Authority;

import javax.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO roleDAO;


    @Override
    @Transactional
    public Authority getRoleById(int roleId) {
        return roleDAO.getRoleById(roleId);
    }
}
