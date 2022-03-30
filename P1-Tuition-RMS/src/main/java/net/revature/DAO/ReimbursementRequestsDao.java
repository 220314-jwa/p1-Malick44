package net.revature.DAO;

import java.util.List;

import net.revature.model.ReimbursementRequests;

public interface ReimbursementRequestsDao extends GenericDao<ReimbursementRequests> {

	@Override
	public List<ReimbursementRequests> getAll();// will return all reimbursement request.

	@Override
	public void create(ReimbursementRequests obj);// will create and save new reimbursement request into database

	@Override
	public ReimbursementRequests getById(int reimbursementRequestId); // get

	@Override
	public void updateById(int id);
}
