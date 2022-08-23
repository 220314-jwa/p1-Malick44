package net.revature.trmsapp.services;

import net.revature.trmsapp.exceptions.IncorrectCredentialsException;
import net.revature.trmsapp.models.Employee;
import net.revature.trmsapp.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAll() {
        List <Employee> employeesList = employeeRepo.findAll();
        return employeesList;
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> employeeOptional= employeeRepo.findById(id);
        Employee employee= employeeOptional.get();
        return employee;
    }

    @Override
    public Employee logIn(String username, String password) throws IncorrectCredentialsException {
        Employee employee= employeeRepo.findByUsername(username);
        return employee;
    }

    @Override
    public Employee register(Employee empObj) {

        employeeRepo.save(empObj);
        return empObj;
    }
}
