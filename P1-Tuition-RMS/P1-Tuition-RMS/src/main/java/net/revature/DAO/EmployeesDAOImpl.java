package net.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.revature.model.Employees;

public class EmployeesDAOImpl implements EmployeesDAO {

	// 1. set up connection object
	Connection connection;

	// 2. set up constructor to with connected state
	public EmployeesDAOImpl() {
		if (connection == null) {
		}
		connection = DAOConnectionUtilities.getConnection();
	}

	@Override
	public List<Employees> getAll() {
		List<Employees> employees = new ArrayList();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMPLOYEES";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery(); // execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				Employees employee = parseResulset(rs);
				employees.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employees;

	}

	private Employees parseResulset(ResultSet rs) throws SQLException {
		Employees employee = new Employees();
		employee.setEmployeeId(rs.getInt(1));
		employee.setFirstName(rs.getString(2));
		employee.setLastName(rs.getString(3));
		employee.setManagerId(rs.getInt(4));
		employee.setDepartmentId(rs.getInt(5));

		return employee;
	}

	@Override
	public int create(Employees newEmployee) {
		// Declare variable in method scoop so we can clean up in finally block

		PreparedStatement pstmt = null;
		ResultSet resultSet;
		int count = 0;
		// sql statement that will insert new object employees table
		String sql = "INSERT INTO employees(employeeId,firstname, lastname, mamagerid, departmentid)"
				+ "VALUES (default,?,?,?,?)";
		// set up a preparedStatement that takes sql and RETURN_GENERATED_KEYS as an
		// argumentS
		try {

			pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, newEmployee.getFirstName());
			pstmt.setString(2, newEmployee.getLastName());
			pstmt.setInt(3, newEmployee.getManagerId());
			pstmt.setInt(4, newEmployee.getDepartmentId());

			count = pstmt.executeUpdate();
			resultSet = pstmt.getGeneratedKeys();
			if (count > 0) {
				System.out.println("The new Employee was added");

				resultSet.next();
				int employeeid = resultSet.getInt(1);
				return employeeid;
			}

		} catch (SQLException e) {
			System.out.println("Insert newEployee failed: ");
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

		}

		return count;

	}

	@Override
	public Employees getById(int id) {
		Employees employee = new Employees();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEEID =? ";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery(); // execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				employee = parseResulset(rs);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public int update(Employees obj) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "UPDATE Employees SET firstname=?, lastname=?, mamagerid= ?, departmentid =? WHERE employeeid =?";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, obj.getFirstName());
				pstmt.setString(2, obj.getLastName());
				pstmt.setInt(3, obj.getManagerId());
				pstmt.setInt(4, obj.getDepartmentId());

				count = pstmt.executeUpdate();
				if (count != 1) {
					System.out.println("Oops! Something went wrong with the update!");

				} else
					connection.commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (pstmt != null)
					try {

						pstmt.close();
						if (connection != null)
							connection.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}

			}

		}

		return count;

	}

	@Override
	public void deleteteById(int id) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "DELETE FROM Employees where EmployeeId =?; ";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, id);
				count = pstmt.executeUpdate();
				if (count != 1) {
					System.out.println("Oops! Something went wrong with the update!");

				} else
					connection.commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (pstmt != null)
					try {

						pstmt.close();
						if (connection != null)
							connection.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}

			}

		}
	}

}
