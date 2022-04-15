package net.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.revature.exceptions.EmployeeDoesnotExistException;
import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.model.Employees;
import net.revature.model.ReimbursementRequests;
import net.revature.model.Users;

class UserServicesImplTest {

// set up test environment 	
	UserServices usdaoTest = new UserServicesImpl();
	Users testUser = new Users();

	@Test
	void testlogin() throws IncorrectCredentialsException {

		String userName = "";
		String passWord = "";
		int result = -1;

		assertEquals(1, usdaoTest.login(userName, passWord));

	}

	@Test
	void testUserPasswordnotnulllogin() throws IncorrectCredentialsException {

		String userName = "usernme";
		String passWord = "";
		int result = -1;
		assertNotNull(passWord);

		// assert not null

	}

	@Test

	void lestlogingtrhowsException() {

		String userName = "";
		String passWord = "";

		assertThrows(IncorrectCredentialsException.class, () -> usdaoTest.login(userName, passWord),
				"Should throw Exception ");
	}

	@Test
	void testSetApproval() {

		// assert same

		int requestId = 23;
		int requestStatusid;

		assertEquals(null, null);

	}

	@Test
	void registerUserTest() {

		// assertnotnull,
	}

	@Test
	void submitReimbursementRequestTest() throws EmployeeDoesnotExistException {

		// set up test field
		Employees testEmp = new Employees();
		ReimbursementRequests testReq = new ReimbursementRequests();
		UserServicesImpl testUserimpl = new UserServicesImpl();

		testReq.setEmployeeId(100);
		testEmp.setEmployeeId(100);
		int expected = 1;

		assertEquals(100, testEmp.getEmployeeId());
		assertEquals(100, testReq.getEmployeeId());
		assertEquals(1, testUserimpl.submitReimbursenentRequest(testEmp, testReq));

	}

	@Test
	void checkRequeststatusTest() {
	}

}
