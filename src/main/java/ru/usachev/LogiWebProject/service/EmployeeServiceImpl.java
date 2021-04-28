package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.dao.EmployeeDAO;
import ru.usachev.LogiWebProject.entity.Employee;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public void addNewEmployee(Employee employee) {
        employeeDAO.addNewEmployee(employee);
    }
}
