package ru.usachev.LogiWebProject.dao;

import ru.usachev.LogiWebProject.entity.Authority;

public interface RoleDAO {
    Authority getRoleById(int roleId);
}
