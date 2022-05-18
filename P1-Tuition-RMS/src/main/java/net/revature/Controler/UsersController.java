package net.revature.Controler;

import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import net.revature.exceptions.AlreadyExistException;
import net.revature.exceptions.EmployeeDoesnotExistException;
import net.revature.exceptions.IncorrectCredentialsException;
import net.revature.model.ReimbursementRequests;
import net.revature.model.RequestStatus;
import net.revature.model.Users;
import net.revature.services.UserServices;
import net.revature.services.UserServicesImpl;

public class UsersController {
	private static UserServices userServ = new UserServicesImpl();

	public static void viewAllRequests(Context ctx) {

		ctx.json(userServ.getAllRequests());

	}

	public static void registerUser(Context ctx) {

		Users newUser = ctx.bodyAsClass(Users.class);
		try {
			newUser = userServ.registerUser(newUser);
			ctx.json(newUser);

		} catch (AlreadyExistException e) {
			ctx.status(HttpCode.CONFLICT); // 409 conflict

		}

	}

	public static void login(Context ctx) {
		Map<String, String> credentials = ctx.bodyAsClass(Map.class);

		String userName = credentials.get("username");
		String passWord = credentials.get("password");

		try {
			Users user = userServ.login(userName, passWord);
			ctx.json(user);

		} catch (IncorrectCredentialsException e) {
		}
	}

	public static void getById(Context ctx) {

		String pathParam = ctx.pathParam("id");
		if (pathParam != null && !pathParam.equals("undefined") && !pathParam.equals("null")) {
			int userId = Integer.parseInt(pathParam);

			Users user = userServ.getUserById(userId);
			if (user != null)
				ctx.json(user);
			else
				ctx.status(HttpCode.NOT_FOUND); // 404 not found
		} else {
			ctx.status(HttpCode.BAD_REQUEST); // 400 bad request
		}

	}

	public static void setApproval(Context ctx) {
		ctx.status(HttpCode.UNAUTHORIZED);
	}

	public static void getStatusById(Context ctx) {
		String pathParam = ctx.pathParam("id");
		if (pathParam != null && !pathParam.equals("undifined") && !pathParam.equals("null")) {
			int requestId = Integer.parseInt(pathParam);
			RequestStatus reqStatus = userServ.getStatusById(requestId);
			if (reqStatus != null) {
				ctx.json(reqStatus);
			} else
				ctx.status(HttpCode.NOT_FOUND);

		} else
			ctx.status(HttpCode.BAD_REQUEST);// 400 bad request

	}

	public static void submitRequest(Context ctx) {

		ReimbursementRequests newReimReq = ctx.bodyAsClass(ReimbursementRequests.class);

		try {
			userServ.submitRequest(newReimReq);
			ctx.json(newReimReq);

		} catch (EmployeeDoesnotExistException e) {
			ctx.status(HttpCode.BAD_REQUEST);

		}

	}

}
