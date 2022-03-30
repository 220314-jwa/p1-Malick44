package net.revature.DAO;

import java.util.List;

import net.revature.model.Department;

public interface DepartmentDao extends GenericDao<Department> {

	@Override
	public List<Department> getAll();

	@Override
	public void create(Department obj);

	@Override
	public Department getById(int id);

	@Override
	public void updateById(int id);

}
