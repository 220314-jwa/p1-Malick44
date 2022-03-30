package net.revature.DAO;

import java.util.List;

import net.revature.model.Employees;

public interface EmployeesDao extends GenericDao<Employees> {

	@Override
	public List<Employees> getAll();

	@Override
	public void create(Employees obj);

	@Override
	public Employees getById(int id);

	@Override
	public void updateById(int id);
}
