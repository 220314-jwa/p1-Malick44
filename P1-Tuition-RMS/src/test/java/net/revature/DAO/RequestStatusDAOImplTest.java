package net.revature.DAO;

import org.junit.jupiter.api.BeforeAll;

import net.revature.model.RequestStatus;

class RequestStatusDAOImplTest {

	private static RequestStatusDAO statusDao = DaoFactory.getStatusDoa();
	private static RequestStatus teststatus = new RequestStatus();
	private static RequestStatus newteststatus = new RequestStatus();

	@BeforeAll
	public static void setUp() {
		// this is the base test pet used for most tests
		teststatus.setStatusId(1);
		teststatus.setStatus("TAproved");

		// this is the pet to test create and delete

		teststatus.setStatus("restuer");

		// TODO create pet in DB with name "test"
		// and set the pet's ID to the returned value

	}

}
