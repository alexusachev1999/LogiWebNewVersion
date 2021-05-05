package ru.usachev.LogiWebProject.dao;

import ru.usachev.LogiWebProject.entity.User;

import java.util.List;

public interface UserDAO {
    public void addNewEmployee(User user);

    User getByLogin(String login);

    List<User> getAllAdminUsers();
}
