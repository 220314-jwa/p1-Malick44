package net.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnectionUtilities {

	private static Connection connection = null; // static connection object

	public static synchronized Connection getConnection() {

		// setting connections variables
		// ResourceBundle bundle = ResourceBundle.getBundle("dbConfig");

		// String url = bundle.getString("url");
		// String userName = bundle.getString("userName");
		// String passWord = bundle.getString("passWord");

		String CONNECTION_USERNAME = "postgres";
		String CONNECTION_PASSWORD = "postgres";
		String URL = "jdbc:postgresql://localhost:5432/P1-TRMS";
		// register data base connection driver

		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver not Register");
				e.printStackTrace();
			}
			System.out.println("connection starting.....");
			try {
				connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
				System.out.println("Connection is good");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection.isClosed()) {
					System.out.println("Please wait getting new connection");
					connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return connection;

	}
}
