package net.revature.DAO;

import java.util.List;

import net.revature.model.RequestStatus;

public interface RequestStatusDAO extends GenericDAO<RequestStatus> {

	@Override
	public List<RequestStatus> getAll();

	@Override
	public int create(RequestStatus obj);

	@Override
	public RequestStatus getById(int employeeId);

	@Override
	public int update(RequestStatus obj);

	@Override
	public void deleteteById(int id);

}
