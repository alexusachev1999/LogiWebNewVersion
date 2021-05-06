package ru.usachev.LogiWebProject.converter;

import org.springframework.stereotype.Component;
import ru.usachev.LogiWebProject.dto.UserDTO;
import ru.usachev.LogiWebProject.entity.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverterImpl implements UserConverter{

    @Override
    public User convertUserDTOToUser(UserDTO userDTO) {
        User user = new User();

        user.setUsername(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(userDTO.isEnabled());

        return user;
    }

    @Override
    public UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setLogin(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEnabled(user.isEnabled());
        userDTO.setAuthority(user.getUserRole().toString());

        return userDTO;
    }

    @Override
    public List<UserDTO> convertUserListToUserDTOList(List<User> users) {
        List<UserDTO> usersDTO = new ArrayList<>();

        for (User u: users){
            usersDTO.add(convertUserToUserDTO(u));
        }

        return usersDTO;
    }
}
