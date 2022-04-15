package net.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.revature.DAO.ReimbursementRequestsDAO;
import net.revature.DAO.ReimbursementRequestsDAOImpl;
import net.revature.DAO.RequestStatusDAO;
import net.revature.DAO.RequestStatusDAOImpl;
import net.revature.DAO.UserDAO;
import net.revature.DAO.UserDAOImpl;
import net.revature.exceptions.AlreadyExistException;
import net.revature.exceptions.EmployeeDoesnotExistException;
import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.model.ReimbursementRequests;
import net.revature.model.RequestStatus;
import net.revature.model.Users;

@ExtendWith(MockitoExtension.class)
class UserServicesImplTest {

	@Mock // says that we want Mockito to create a mock version of this object
	private UserDAO userDao = new UserDAOImpl();
	@Mock
	private RequestStatusDAO statusDao = new RequestStatusDAOImpl();

	@Mock
	private ReimbursementRequestsDAO reimbReqDao = new ReimbursementRequestsDAOImpl();;

	// we need a field for the class we are testing
	@InjectMocks //
	private UserServices userServ = new UserServicesImpl();

	@Test
	void testloginsuccesfully() throws IncorrectCredentialsException {

		String userName = "Narway";
		String passWord = "James";

		Users mocker = new Users();
		mocker.setUserName(userName);
		mocker.setPassWord(passWord);
		when(userDao.getByUserName(userName)).thenReturn(mocker);

		Users result = userServ.login(userName, passWord);

		assertEquals(userName, result.getUserName());

	}

	@Test
	void testIncorrectPassWord() throws IncorrectCredentialsException {

		String userName = "usernme";
		String passWord = "pass";

		Users mocker = new Users();
		mocker.setUserName(userName);
		mocker.setPassWord(passWord);
		when(userDao.getByUserName(userName)).thenReturn(null);

		assertThrows(IncorrectCredentialsException.class, () -> {

			userServ.login(userName, passWord);
		});
	}

	@Test

	void lestlogingtrhowsException() {

		// set up

		String userName = "";
		String passWord = "";

	}

	@Test
	void testSetApprovalsuccessfully() {

		int requestId = 11;
		ReimbursementRequests mocker = new ReimbursementRequests();
		mocker.setRequestId(requestId);
		mocker.setStatusId(1);

		when(reimbReqDao.getById(requestId)).thenReturn(mocker);

		RequestStatus newreq = userServ.setApproval(requestId);

		assertEquals(1, newreq.getStatusId());

	}

	@Test
	void registerUserTestshoulfail() throws AlreadyExistException {

		UserServices userServ = new UserServicesImpl();
		Users mocker = new Users();
		Users newuser = new Users();

		when(userDao.create(newuser)).thenReturn(1);

		newuser.setUserName("rama");

		Users result = userServ.registerUser(newuser);

		assertEquals(result.getUserName(), mocker.getUserName());
	}

	@Test
	void submitReimbursementRequestTest() throws EmployeeDoesnotExistException {

		// set up test field

		ReimbursementRequests testReq = new ReimbursementRequests();
		UserServicesImpl testUserimpl = new UserServicesImpl();

		testReq.setEmployeeId(100);
		int expected = 1;

		assertEquals(100, testReq.getEmployeeId());
		assertEquals(1, testUserimpl.submitRequest(testReq));

	}

	@Test
	void getstatusTestsucces() {

		int resquestId = 24;

		RequestStatus mocker = new RequestStatus();
		mocker.setRequestId(resquestId);

		when(statusDao.getById(resquestId)).thenReturn(mocker);

		userServ.getStatusById(resquestId);

		assertEquals(24, mocker.getRequestId());

	}

	@Test
	void getUserByIdtestSuccessfully() {

		int id = 56;
		Users mocker = new Users();
		mocker.setEmployeeId(id);

		when(userDao.getById(id)).thenReturn(mocker);

		assertEquals(mocker, userServ.getUserById(id));

	}

}
