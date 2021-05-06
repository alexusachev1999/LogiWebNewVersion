package ru.usachev.LogiWebProject.dao;


import ru.usachev.LogiWebProject.entity.User;

public interface UserDao {

	User findByUserName(String username);

}