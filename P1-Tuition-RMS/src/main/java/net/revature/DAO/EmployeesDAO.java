package net.revature.DAO;

import java.util.List;

import net.revature.model.Employees;

public interface EmployeesDAO extends GenericDAO<Employees> {

	/*
	 * employees DAO interface lay out all the task employees will be able to
	 * perform including CRUD .
	 */

	@Override
	public List<Employees> getAll();

	@Override
	public int create(Employees newEmployee);

	@Override
	public Employees getById(int id);

	@Override
	public int update(Employees obj);

	@Override
	public void deleteteById(int id);

}
