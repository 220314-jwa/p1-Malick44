package net.revature.trmsapp.repositories;

import net.revature.trmsapp.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
