package net.revature.DAO;

import java.util.List;

import javax.swing.event.DocumentEvent.EventType;

public interface EventTypeDAO extends GenericDAO<EventType> {

	@Override
	public List<EventType> getAll();

	@Override
	public int create(EventType obj);

	@Override
	public EventType getById(int id);

	@Override
	public int update(EventType obj);

	@Override
	public void deleteteById(int id);

}
