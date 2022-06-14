package net.revature.DAO;

import net.revature.model.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDAOImplTest {
//Given
        DepartmentDAO depDao = new DepartmentDAOImpl();
        Department departmentObj = new Department(6, "Production", 11);

    @Test
    @DisplayName("GetAllDepartments")
    void getAll() {
        // when
        List<Department> departmentList = depDao.getAll();
        assertNotNull(departmentList);
    }

    @Test
    void create() {
        // When
       int result =  depDao.create(departmentObj);
        //Then
        assertEquals(6,result);
    }

    @Test
    void getById() {
        Department departmenttest = depDao.getById(6);
        assertEquals(6, departmenttest.getDepartmentId());
    }


}