package net.revature.DAO;

import java.util.List;

import net.revature.model.EventTypes;

public interface EventTypeDAO extends GenericDAO<EventTypes> {

	@Override
	public List<EventTypes> getAll();

	@Override
	public int create(EventTypes obj);

	@Override
	public EventTypes getById(int id);

	@Override
	public int update(EventTypes obj);

	@Override
	public void deleteteById(int id);

}
