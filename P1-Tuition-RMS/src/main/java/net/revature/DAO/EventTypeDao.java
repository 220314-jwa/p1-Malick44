package net.revature.DAO;

import java.util.List;

import javax.swing.event.DocumentEvent.EventType;

public interface EventTypeDao extends GenericDao<EventType> {

	@Override
	public List<EventType> getAll();

	@Override
	public void create(EventType obj);

	@Override
	public EventType getById(int id);

	@Override
	public void updateById(int id);

}
