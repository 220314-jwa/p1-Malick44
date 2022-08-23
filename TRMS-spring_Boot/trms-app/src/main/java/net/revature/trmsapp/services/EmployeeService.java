package net.revature.trmsapp.services;

import net.revature.trmsapp.exceptions.IncorrectCredentialsException;
import net.revature.trmsapp.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {

    public List<Employee> getAll();
    public Employee getById( int id);


    public Employee logIn(String username, String password) throws IncorrectCredentialsException;
    public Employee register(Employee empObj);


}
