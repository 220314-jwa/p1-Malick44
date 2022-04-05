/**
 * 
 */
package net.revature.services;

import java.util.List;

import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.model.Employees;
import net.revature.model.ReimbursementRequests;
import net.revature.model.RequestStatus;
import net.revature.model.Users;

// employees services interface include all methods employees will be able to perform

public interface UserServices {

	public int login(String userName, String passWord) throws IncorrectCredentialsException;

	public void setApproval(int requestId);// method will can approve or reject

	public RequestStatus checkReimbursementRequestsStatus(int requestid);

	public int registerUser(Users newUser);

	public int submitReimbursenentRequest(Employees empObj, ReimbursementRequests requestObj);

	List<Users> getAllUsers();

}
