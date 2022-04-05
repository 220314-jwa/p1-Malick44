package net.revature.services;

import java.util.List;

import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.model.Employees;
import net.revature.model.ReimbursementRequests;
import net.revature.model.RequestStatus;
import net.revature.model.Users;

public class UserServicesImpl implements UserServices {

	@Override
	public int login(String userName, String passWord) throws IncorrectCredentialsException {

		Users newuser = Users.getUser(userName);

		if (userName != null && newuser.getPassWord().equals(passWord)) {
			newuser.setLoggedIn(true);
			return 1;
		} else
			throw new IncorrectCredentialsException();

	}

	@Override
	public void setApproval(int requestId) {

	}

	@Override
	public RequestStatus checkReimbursementRequestsStatus(int requestid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int submitReimbursenentRequest(Employees empObj, ReimbursementRequests requestObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerUser(Users newUser) {

		return 0;
	}

	@Override
	public List<Users> getAllUsers() {

		return null;
	}

}
