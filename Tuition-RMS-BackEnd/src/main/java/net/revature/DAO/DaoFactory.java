package net.revature.DAO;

import net.revature.model.Users;

public class DaoFactory {
	private static DepartmentDAO dptdao = null;
	private static EmployeesDAO empldao = null;
	private static EventTypeDAO evtDAO = null;
	private static RequestStatusDAO statusDoa = null;
	private static ReimbursementRequestsDAO ReimbRequestDao = null;
	private static UserDAO userDao = null;
	private static Users user = null;

	private DaoFactory() {
	}

	public static Users getUser() {
		if (user == null) {
			user = new Users();
		}
		return user;
	}

	public static RequestStatusDAO getStatusDoa() {
		if (statusDoa == null) {
			statusDoa = new RequestStatusDAOImpl();
		}
		return statusDoa;
	}

	public static DepartmentDAO getDptdao() {

		if (dptdao == null) {
			dptdao = new DepartmentDAOImpl();
		}
		return dptdao;
	}

	public static EmployeesDAO getEmpldao() {
		if (empldao == null) {
			empldao = new EmployeesDAOImpl();
		}
		return empldao;
	}

	public static EventTypeDAO getEvtDAO() {
		if (evtDAO == null) {
			evtDAO = new EventTypeDAOImpl();
		}
		return evtDAO;
	}

	public static ReimbursementRequestsDAO getReimbRequestDao() {
		if (ReimbRequestDao == null) {
			ReimbRequestDao = new ReimbursementRequestsDAOImpl();
		}
		return ReimbRequestDao;
	}

	public static UserDAO getUserDAO() {

		if (userDao == null) {
			userDao = new UserDAOImpl();
		}
		return userDao;

	}

}
