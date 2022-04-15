package net.revature.app;

import java.util.List;

import io.javalin.Javalin;
import net.revature.DAO.DaoFactory;
import net.revature.DAO.DepartmentDAO;
import net.revature.model.Department;

public class TRMSApplication {
	public static void main(String[] args) {

		/*
		 * Department department = new Department();
		 * 
		 * department.setDepartmentHeadId(2); department.setDepartmentName("Developer");
		 * department.setDepartmentHeadId(10002);
		 */
		// DepartmentDAO dpDao = DaoFactory.getDptdao();
		// dpDao.getAll();

		// EmployeesDAO empDao = DaoFactory.getEmpldao();
		// empDao.getAll();

		/*
		 * Users newuser = new Users(); newuser.setFirstName("Ramon");
		 * newuser.setLastName("Colona"); newuser.setUserName("Alex4");
		 * newuser.setPassWord("pass");
		 * 
		 * UserDAO userdao = DaoFactory.getUserDAO();
		 * 
		 * userdao.getAll();
		 */

		Javalin app = Javalin.create();
		app.start(9999);

		app.post("/Departments",

				ctx -> {
					Department department = ctx.bodyAsClass(net.revature.model.Department.class);
					DepartmentDAO dpdao = DaoFactory.getDptdao();
					int id = dpdao.create(department);
					ctx.resultString();

				});

		app.get("/Departments", ctx -> {

			DepartmentDAO dpdao = DaoFactory.getDptdao();
			List<Department> departments = dpdao.getAll();
			ctx.json(departments);

		});

		// GET to /pets: get available pets

		// .json() is an alternative to .result() that
		// sets the data type as JSON, the format that we
		// will be sending/receiving data in!

		// POST to /users: register a new user

		// context bodyAsClass method will transform JSON data into
		// a Java object as long as the JSON keys match the Java fields

		// POST to /auth: log in

		// if the keys in JSON data don't exactly match a class,
		// we can just use a Map!

		// PUT to /pets/{id}/adopt where {id} will be a number (a pet ID): adopt pet

		// first we can grab the ID from the URI
		// since it is part of the path (URI) it is a path parameter
		// so we use ctx.pathParam and use the name we specified in
		// the path above

		// now we need to get the User from the request body

		// now we have everything we need to adopt the pet

		// then we can return the updated user

		// 409 conflict
	}

}
