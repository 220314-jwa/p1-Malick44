package net.revature.services;

import java.util.List;

import net.revature.DAO.DaoFactory;
import net.revature.DAO.ReimbursementRequestsDAO;
import net.revature.DAO.UserDAO;
import net.revature.exceptions.EmployeeDoesnotExistException;
import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.exceptions.UserNameAlredyExistException;
import net.revature.model.Employees;
import net.revature.model.ReimbursementRequests;
import net.revature.model.RequestStatus;
import net.revature.model.Users;

public class UserServicesImpl implements UserServices {

	private UserDAO userdao = DaoFactory.getUserDAO();
	private ReimbursementRequestsDAO rDao = DaoFactory.getReimbRequestDao();

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
	public int submitReimbursenentRequest(Employees empObj, ReimbursementRequests requestObj)
			throws EmployeeDoesnotExistException {

		if (empObj.getEmployeeId() != requestObj.getEmployeeId()) {
			throw new EmployeeDoesnotExistException();

		} else
			rDao.create(requestObj);

		return 0;

	}

	@Override
	public int registerUser(Users newUser) throws UserNameAlredyExistException {
		if (newUser.getUserName() != null) {
			throw new UserNameAlredyExistException();
		} else
			userdao.create(newUser);

		return 1;
	}

	@Override
	public List<Users> getAllUsers() {

		return null;
	}

}
