/**
 * 
 */
package net.revature.services;

import net.revature.model.Employees;
import net.revature.model.RequestStatus;

// employees services interface include all methods employees will be able to perform

public interface EmployeesServices {

	public Employees login(String userName, String password);

	public Employees register(Employees obj);

	public void submitReimbursementRequests(int eventId);

	public void setApproval(int reimbursementRequestid);// method will can approve or reject

	public RequestStatus checkReimbursementRequestsStatus(int ReimbursementRequestid);

}
