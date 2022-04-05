package net.revature.DAO;

import java.util.List;

// CRUD for Department interface

import net.revature.model.Department;

public interface DepartmentDAO extends GenericDAO<Department> {

	@Override
	public List<Department> getAll();

	@Override
	public int create(Department obj);

	@Override
	public Department getById(int id);

	@Override
	public int update(Department obj);

	@Override
	public void deleteteById(int id);

	public Department getEmployeeById(int id);

	public int createEmployee(Department obj);

}
