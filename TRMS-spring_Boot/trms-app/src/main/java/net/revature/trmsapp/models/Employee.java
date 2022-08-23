package net.revature.trmsapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int employeeId;
    private String firstName;
    private String lastName;
    private int managerId;
    private int departmentId;
    private String username;
    private String password;
}
