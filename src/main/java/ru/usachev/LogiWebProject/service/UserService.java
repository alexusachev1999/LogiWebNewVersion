package ru.usachev.LogiWebProject.service;

import ru.usachev.LogiWebProject.dto.UserDTO;
import ru.usachev.LogiWebProject.entity.User;

import java.util.List;

public interface UserService {
    public void addNewEmployee(User user);

    List<UserDTO> getAllAdminUsers();
}
