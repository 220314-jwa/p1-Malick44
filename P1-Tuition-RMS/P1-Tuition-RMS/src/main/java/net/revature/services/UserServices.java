/**
 * 
 */
package net.revature.services;

import java.util.List;

import net.revature.exceptions.AlreadyExistException;
import net.revature.exceptions.EmployeeDoesnotExistException;
import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.model.ReimbursementRequests;
import net.revature.model.RequestStatus;
import net.revature.model.Users;

// employees services interface include all methods employees will be able to perform

public interface UserServices {

	public List<ReimbursementRequests> getAllRequests();

	public Users registerUser(Users newUser) throws AlreadyExistException;

	public Users login(String userName, String passWord) throws IncorrectCredentialsException;

	public RequestStatus setApproval(int requestId);// method will can approve or reject

	public RequestStatus getStatusById(int requestId);

	public int submitRequest(ReimbursementRequests requestObj) throws EmployeeDoesnotExistException;

	public Users getUserById(int id);

}
