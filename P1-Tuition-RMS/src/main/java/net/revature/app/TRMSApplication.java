package net.revature.app;

//this allows you to use the routes methods (path, etc.)
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import io.javalin.Javalin;
import net.revature.Controler.UsersController;
import net.revature.services.UserServices;
import net.revature.services.UserServicesImpl;

public class TRMSApplication {

	private static UserServices userServ = new UserServicesImpl();

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
		});
		app.start(9999);

		app.routes(() -> {
			// all path start with Home
			path("Home", () -> {
				get(UsersController::viewAllRequests);

				path("{id}", () -> {

					get(UsersController::getStatusById);

					put("Requests", UsersController::getStatusById);
				});

			});
			path("USers", () -> {

				post(UsersController::registerUser);
				path("{id}", () -> {
					// get(UsersController::get);
				});

			});

		});

		// ReimbursementRequestsDAO reimDao = DaoFactory.getReimbRequestDao();

//		UserServices userServ = new UserServicesImpl();
//		RequestStatusDAO rqDao = DaoFactory.getStatusDoa();
//		// ReimbursementRequests reimbReq = reimDao.getById(8);
//		RequestStatus newStatus = userServ.getStatusById(8);
//		// System.out.println(reimbReq);
//
//		System.out.println(newStatus);

//		EventTypeDAO eventdao = DaoFactory.getEvtDAO();
//		EventTypes neweventype = new EventTypes();
//
//		neweventype.setEventTypeId(201);
//		neweventype.setEventTypeName(" Advance Java certification");
//		eventdao.create(neweventype);
//		System.out.println(neweventype);

//		Javalin app = Javalin.create();
//		app.start(9999);
//
//		app.post("/Departments",
//
//				ctx -> {
//					Department department = ctx.bodyAsClass(net.revature.model.Department.class);
//					DepartmentDAO dpdao = DaoFactory.getDptdao();
//					int id = dpdao.create(department);
//					ctx.resultString();
//
//				});
//
//		app.get("/Departments", ctx -> {
//
//			DepartmentDAO dpdao = DaoFactory.getDptdao();
//			Department departments = dpdao.getById(2);
//			ctx.json(departments);
//
//		});

	}

}
