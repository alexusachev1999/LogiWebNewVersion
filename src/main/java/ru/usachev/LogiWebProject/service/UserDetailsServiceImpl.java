package ru.usachev.LogiWebProject.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.usachev.LogiWebProject.dao.UserDAO;
import ru.usachev.LogiWebProject.dto.UserDTO;
import ru.usachev.LogiWebProject.entity.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) {
        User user = userDAO.getByLogin(login);

        if (user != null) {
            UserDTO userDTO = mapper.map(user, UserDTO.class);
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();


            grantedAuthorities.add(new SimpleGrantedAuthority(user.getAuthority().getAuthority()));

            return new org.springframework.security.core.userdetails.User(userDTO.getLogin(), userDTO.getPassword(),
                    grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("User is not found.");
        }
    }
}
