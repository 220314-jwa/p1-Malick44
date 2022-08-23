package net.revature.services;

import java.util.ArrayList;
import java.util.List;

import net.revature.DAO.DaoFactory;
import net.revature.DAO.ReimbursementRequestsDAO;
import net.revature.DAO.ReimbursementRequestsDAOImpl;
import net.revature.DAO.RequestStatusDAO;
import net.revature.DAO.UserDAO;
import net.revature.exceptions.AlreadyExistException;
import net.revature.exceptions.EmployeeDoesnotExistException;
import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.model.ReimbursementRequests;
import net.revature.model.RequestStatus;
import net.revature.model.Users;

public class UserServicesImpl implements UserServices {

	private UserDAO userdao = DaoFactory.getUserDAO();
	private ReimbursementRequestsDAO rDao = DaoFactory.getReimbRequestDao();

	private RequestStatusDAO statustDao = DaoFactory.getStatusDoa();

	@Override
	public Users login(String userName, String passWord) throws IncorrectCredentialsException {

		Users user = userdao.getByUserName(userName);

		if (userName != null && user.getPassWord().equals(passWord)) {

			user.setLoggedIn(true);
			return user;
		} else {

			throw new IncorrectCredentialsException();

		}

	}

	@Override
	public void setApproval(int requestId) {
		// approve conditions:
		// the cost must be less $3000;
		// submit date must must be valid
		ReimbursementRequestsDAO rDao = DaoFactory.getReimbRequestDao();
		ReimbursementRequests reimbReq = rDao.getById(requestId);
		if (reimbReq.getCost() > 3000 || reimbReq.getEventDate() == null) {

			reimbReq.setStatusId(0);

		} else { reimbReq.setStatusId(1);}

	}

	@Override
	public RequestStatus getStatusById(int requestId) {

		RequestStatus newStatus = statustDao.getById(requestId);

		return newStatus;
	}

	@Override
	public int submitRequest(ReimbursementRequests requestObj) throws EmployeeDoesnotExistException {

		if (requestObj.getEmployeeId() != 0) {

			rDao.create(requestObj);

		} else {
			throw new EmployeeDoesnotExistException();
		}

		return requestObj.getEmployeeId();

	}

	@Override
	public Users registerUser(Users newUser) throws AlreadyExistException {
      int employeeId = userdao.create(newUser);
if (employeeId!=0){
return newUser;}
else{
	throw new AlreadyExistException();

}
	}

	@Override
	public List<ReimbursementRequests> getAllRequests() {

		List<ReimbursementRequests> requestList = new ArrayList();

		ReimbursementRequestsDAO rDao = new ReimbursementRequestsDAOImpl();

		requestList = rDao.getAll();

		return requestList;

	}

	@Override
	public List<ReimbursementRequests> getAllUserRequests(int employeeId) {
			List<ReimbursementRequests> userRequests = new ArrayList<>();
			userRequests= rDao.getByEmployeeId( employeeId);

			return userRequests;
	}


	@Override
	public Users getUserById(int id) {
		Users newUser = new Users();
		newUser = userdao.getById(id);
		return newUser;
	}

//	@Override
//	public int registerUser(Users newUser) throws UserNameAlredyExistException {
//		if (newUser.getUserName() != null) {
//			throw new UserNameAlredyExistException();
//		} else
//			userdao.create(newUser);
//
//		return 1;
//	}

}
