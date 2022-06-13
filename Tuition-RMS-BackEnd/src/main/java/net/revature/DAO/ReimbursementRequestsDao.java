package net.revature.DAO;

import java.util.List;

import net.revature.model.ReimbursementRequests;

public interface ReimbursementRequestsDAO extends GenericDAO<ReimbursementRequests> {

	@Override
	public List<ReimbursementRequests> getAll();// will return all reimbursement request.

	@Override
	public int create(ReimbursementRequests obj);// will create and save new reimbursement request into database

	@Override
	public ReimbursementRequests getById(int reimbursementRequestId); // get

	@Override
	public int update(ReimbursementRequests obj);

	@Override
	public void deleteteById(int id);
}
