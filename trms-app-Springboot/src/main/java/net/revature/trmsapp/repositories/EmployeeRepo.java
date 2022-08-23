package net.revature.trmsapp.repositories;

import net.revature.trmsapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
   public Employee findByUsername(String username);
}
