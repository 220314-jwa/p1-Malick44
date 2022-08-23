package net.revature.trmsapp.services;

import net.revature.trmsapp.exceptions.IncorrectCredentialsException;
import net.revature.trmsapp.models.Employee;
import net.revature.trmsapp.repositories.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    public EmployeeService employeeService;
    @MockBean
    public EmployeeRepo employeeRepo;

    @Test
    void findById() {
    }

    @Test
    void logIn() throws IncorrectCredentialsException {
        Employee employeeTest = new Employee();
        employeeTest.setEmployeeId(1);
        employeeTest.setFirstName("Grinder");
        employeeTest.setUsername("Grinder");
        employeeTest.setPassword("Ipass");


        Employee expectedEmployee = new Employee();
        when(employeeRepo.findByUsername("Grinder")).thenReturn(employeeTest);

       expectedEmployee = employeeService.logIn(employeeTest.getUsername(), employeeTest.getPassword());
        verify(employeeRepo, times(1)).findByUsername("Grinder");

        assertEquals(expectedEmployee.getFirstName(), employeeTest.getFirstName());


    }

    @Test
    void register() {
        Employee employeeTest = new Employee();
        employeeTest.setFirstName("Grinder");
        employeeTest.setUsername("Grinder");
        employeeTest.setPassword("Ipass");
        employeeTest.setEmployeeId(1);
        employeeTest.setLastName("Jack");
        employeeTest.setDepartmentId(1);
        employeeTest.setManagerId(1);

        Employee expectedEmployee = new Employee();
        when(employeeRepo.save(employeeTest)).thenReturn(employeeTest);
        expectedEmployee = employeeService.register(employeeTest);
        verify(employeeRepo, times(1)).save(employeeTest);
       // assertEquals(expectedEmployee,employeeTest);

    }
}