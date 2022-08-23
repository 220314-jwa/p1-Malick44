package net.revature.trmsapp.controllers;

import net.revature.trmsapp.models.Employee;
import net.revature.trmsapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/employees")
    public ResponseEntity<Employee> findByUserName(){
        return null;
    }

    @PostMapping("/employees/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> register(Employee empObj){employeeService.register(empObj);

        return null;
    }

    @PostMapping
    public ResponseEntity<Employee> login( @RequestBody Employee empObj){

        return null;
    }






}
