package net.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.revature.model.RequestStatus;

public class RequestStatusDAOImpl implements RequestStatusDAO {

	@Override
	public List<RequestStatus> getAll() {
		List<RequestStatus> requestStatusList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RequestStatus";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery(); // execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				RequestStatus requestStatus = parseResulset(rs);
				requestStatusList.add(requestStatus);
				// for (Department d : departments) {
				// System.out.println(d);
				// }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestStatusList;
	}

	@Override
	public int create(RequestStatus obj) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "INSERT INTO RequestStatus (RequestId, statusId, status )" + "VALUES (?,?,?)";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);

				pstmt.setInt(1, obj.getRequestId());
				pstmt.setInt(2, obj.getStatusId());
				pstmt.setString(3, obj.getStatus());

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
	public RequestStatus getById(int requestId) {
		RequestStatus requestStatus = new RequestStatus();
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;

		String sql = "SELECT * FROM RequestStatus where requestId=?";
		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, requestId);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					requestStatus = parseResulset(rs);

				}

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
		return requestStatus;
	}

	private RequestStatus parseResulset(ResultSet rs) throws SQLException {

		RequestStatus requeststatus = new RequestStatus();
		requeststatus.setRequestId(rs.getInt(1));
		requeststatus.setStatusId(rs.getInt(2));
		requeststatus.setStatus(rs.getString(3));

		return requeststatus;
	}

	@Override
	public int update(RequestStatus obj) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "UPDATE Requeststatus SET statusid = ?, status =? where requesid =?";//

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, obj.getStatusId());

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

		String sql = "DELETE FROM Requeststatus where requestid =?; ";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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
