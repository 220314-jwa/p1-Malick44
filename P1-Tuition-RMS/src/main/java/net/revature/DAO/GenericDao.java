package net.revature.DAO;

import java.util.List;

public interface GenericDao<T> {

	public List<T> getAll();// should return a list of all objects

	public void create(T obj); // should be added a type list

	public T getById(int id);// should return the type object

	public void updateById(int id); // should update record of type object

}
