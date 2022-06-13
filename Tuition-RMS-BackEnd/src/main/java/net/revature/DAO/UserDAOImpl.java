package net.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.revature.model.Users;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<Users> getAll() {

		List<Users> users = new ArrayList();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery(); // execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				Users user = parseResulset(rs);
				users.add(user);
				for (Users d : users) {
					System.out.println(d);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;

	}

	private Users parseResulset(ResultSet rs) throws SQLException {
		Users user = new Users();

		user.setEmployeeId(rs.getInt(1));
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setUserName(rs.getString(4));
		user.setPassWord(rs.getString(5));

		return user;
	}

	@Override
	public int create(Users newuser) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;

		List<Users> usersList = getAll();

		String sql = "INSERT INTO users (emplyeeId, firstName, lastName, userName, password)" + "VALUES (?,?,?,?,?)"
				;

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1,newuser.getEmployeeId());
				pstmt.setString(2, newuser.getFirstName());
				pstmt.setString(3, newuser.getLastName());
				pstmt.setString(4, newuser.getUserName());
				pstmt.setString(5, newuser.getPassWord());
				connection.setAutoCommit(false); // for ACID (transaction management)
				 count = pstmt.executeUpdate();



					// return the generated id:
					// before we call resultSet.next(), it's basically pointing to nothing useful
					// but moving that pointer allows us to get the information that we want


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
	public Users getById(int id) {
		Users user = DaoFactory.getUser();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users WHERE  employeeId =?";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			// execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				user = parseResulset(rs);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public Users getByUserName(String userName) {
		Users user = DaoFactory.getUser();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users WHERE  username =?";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);

			rs = pstmt.executeQuery();
			// execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				user = parseResulset(rs);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int update(Users obj) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "update users set employeeId =?, firstName =?, lastName =? where userName =?)";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, obj.getEmployeeId());
				pstmt.setString(2, obj.getFirstName());
				pstmt.setString(3, obj.getLastName());
				pstmt.setString(4, obj.getUserName());

				count = pstmt.executeUpdate();

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

		String sql = "DELETE FROM Users where employeeId =?; ";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, id);
				count = pstmt.executeUpdate();
				if (count != 1) {
					System.out.println("Oops! Something went wrong with the update!");

				} else
					connection.setAutoCommit(false);
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
