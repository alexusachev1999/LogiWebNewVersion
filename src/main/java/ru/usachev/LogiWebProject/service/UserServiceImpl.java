package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.converter.UserConverter;
import ru.usachev.LogiWebProject.dao.UserDAO;
import ru.usachev.LogiWebProject.dto.UserDTO;
import ru.usachev.LogiWebProject.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserConverter userConverter;

    @Override
    @Transactional
    public void addNewEmployee(User user) {
        userDAO.addNewEmployee(user);
    }

    @Override
    @Transactional
    public List<UserDTO> getAllAdminUsers() {
        List<User> users = userDAO.getAllAdminUsers();
        List<UserDTO> usersDTO = userConverter.convertUserListToUserDTOList(users);
        return usersDTO;
    }
}
