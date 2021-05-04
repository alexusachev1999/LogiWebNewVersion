package ru.usachev.LogiWebProject.dao;

import ru.usachev.LogiWebProject.entity.User;

public interface EmployeeDAO {
    public void addNewEmployee(User user);

    User getByLogin(String login);
}
