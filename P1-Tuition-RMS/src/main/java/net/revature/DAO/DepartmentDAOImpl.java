package net.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.revature.model.Department;

// Department DAO implement
public class DepartmentDAOImpl implements DepartmentDAO {

	//

	@Override
	public List<Department> getAll() {

		List<Department> departments = new ArrayList();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPARTMENT";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery(); // execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				Department department = parseResulset(rs);
				departments.add(department);
				for (Department d : departments) {
					System.out.println(d);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return departments;
	}

	private Department parseResulset(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setDepartmentId(rs.getInt(1));
		department.setDepartmentName(rs.getString(2));
		department.setDepartmentHeadId(rs.getInt(3));

		return department;

	}

	@Override
	public int create(Department obj) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO department(departmentid, departmentname, departmentHeadid)" + "VALUES (default,?,?)";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, obj.getDepartmentName());
				pstmt.setInt(2, obj.getDepartmentHeadId());
				int count = pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				rs.next();
				int departmentid = rs.getInt(1);
				obj.setDepartmentId(departmentid);

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

		return obj.getDepartmentId();

	}

	@Override
	public Department getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Department obj) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "UPDATE department SET departmentname =?, departmentheadid =?  where DepartmentId =?; ";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(0, obj.getDepartmentName());
				pstmt.setInt(1, obj.getDepartmentHeadId());
				pstmt.setInt(2, obj.getDepartmentId());

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

		String sql = "DELETE FROM department where DepartmentId =?; ";

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

		// TODO Auto-generated method stub

	}

	@Override
	public Department getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createEmployee(Department obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
