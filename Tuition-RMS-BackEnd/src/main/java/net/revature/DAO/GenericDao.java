package net.revature.DAO;

import java.util.List;

// CRUD generic interface will be used to Create, Update, Delete, and retrieve lists
public interface GenericDAO<T> {

	public List<T> getAll();// should return a list of all objects

	public int create(T obj); // should be added a type list

	public T getById(int id);// should return the type object

	public int update(T obj); // should update record of type object

	public void deleteteById(int id); // will delete object using id
}
