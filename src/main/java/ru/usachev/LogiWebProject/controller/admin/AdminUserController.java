package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.usachev.LogiWebProject.dto.UserDTO;
import ru.usachev.LogiWebProject.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllAdminUsers(Model model){
        List<UserDTO> users = userService.getAllAdminUsers();

        model.addAttribute("users", users);
        return "admin/all-admin-users";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        return "";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(){
        return "";
    }
}
