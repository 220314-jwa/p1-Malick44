package net.revature.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

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
	private UserDAO userDao;
	@Mock
	private RequestStatusDAO statusDao;

	@Mock
	private ReimbursementRequestsDAO reimbReqDao;

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
		ReimbursementRequests mocker = new ReimbursementRequests();
		ReimbursementRequests expected = new ReimbursementRequests();
		expected.setStatusId(1);
		mocker.setRequestId(11);
		mocker.setStatusId(0);
		mocker.setEmployeeId(2);
		mocker.setCost(324.00);
		mocker.setEventTypeId(2);
		 userServ.setApproval(11);


	}

	@Test
	void registerUserTestshoulfail() throws AlreadyExistException {

		UserServices userServ = new UserServicesImpl();
		Users mocker = new Users();
		Users newuser = new Users();
		newuser.setUserName("rama");
		newuser.setEmployeeId(1);
		when(userDao.create(newuser)).thenReturn(1);
		Users result = userServ.registerUser(newuser);
		verify(userDao,times(1)).create(newuser);
		assertNotEquals(1,result.getEmployeeId());


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
		RequestStatus tesReq = new RequestStatus();
		tesReq.setStatus("approved");
		tesReq.setRequestId(24);

		mocker.setRequestId(resquestId);
		mocker.setStatus("approved");

		when(statusDao.getById(resquestId)).thenReturn(mocker);

		RequestStatus result = userServ.getStatusById(resquestId);
		verify(statusDao,times(1)).getById(resquestId);

		assertEquals("approved", result.getStatus());

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
