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

		user.setId(rs.getInt(1));
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setUserName(rs.getString(4));

		return user;
	}

	@Override
	public int create(Users obj) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "INSERT INTO users (userid, firstName, lastName, userName)" + "VALUES (default,?,?,?)";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, obj.getFirstName());
				pstmt.setString(2, obj.getLastName());
				pstmt.setString(3, obj.getUserName());
				pstmt.setString(4, obj.getPassWord());
				count = pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				rs.next();
				int userid = rs.getInt(1);
				obj.setId(userid);

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Users obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteteById(int id) {
		// TODO Auto-generated method stub

	}

}
