package net.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.model.Users;

class UserServicesImplTest {

// set up test environment 	
	UserServices usdaoTest = new UserServicesImpl();
  Users testUser = new Users();
 
   testUser.
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
	void submitReimbursementRequestTest() {
	}

	@Test
	void checkRequeststatusTest() {
	}

}
