package net.revature.trmsapp.models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int departmentId;
    private String departmentName;
    private int departmentHeadId;

}
