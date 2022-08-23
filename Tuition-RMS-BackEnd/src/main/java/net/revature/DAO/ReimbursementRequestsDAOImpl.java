package net.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.revature.model.ReimbursementRequests;

public class ReimbursementRequestsDAOImpl implements ReimbursementRequestsDAO {

	@Override
	public List<ReimbursementRequests> getAll() {

		List<ReimbursementRequests> reimbursementRequests = new ArrayList();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ReimbursementRequests";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery(); // execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				ReimbursementRequests reimbRequest = parseResulset(rs);
				reimbursementRequests.add(reimbRequest);
				for (ReimbursementRequests d : reimbursementRequests) {
					System.out.println(d);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return reimbursementRequests;

	}

	private ReimbursementRequests parseResulset(ResultSet rs) throws SQLException {
		ReimbursementRequests reimbRequest = new ReimbursementRequests();
		reimbRequest.setRequestId(rs.getInt(1));
		reimbRequest.setEmployeeId(rs.getInt(2));
		reimbRequest.setEventTypeId(rs.getInt(3));
		reimbRequest.setStatusId(rs.getInt(4));
		reimbRequest.setCost(rs.getDouble(5));
		reimbRequest.setEventDate(rs.getDate(6));
		reimbRequest.setDescription(rs.getString(7));
		reimbRequest.setLacation(rs.getString(8));
		reimbRequest.setSubmissionTime(rs.getTime(9));

		return reimbRequest;
	}

	@Override
	public int create(ReimbursementRequests obj) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO ReimbursementRequests(requestId, employeeId, eventTypeId,statusId, Cost,"
				+ "eventDate,description, location, submissionTime)" + "VALUES (default,?,?,?,?,?,?,?,?)";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, obj.getEmployeeId());
				pstmt.setInt(2, obj.getEventTypeId());
				pstmt.setInt(3, obj.getStatusId());
				pstmt.setDouble(4, obj.getCost());
				pstmt.setDate(5, obj.getEventDate());
				pstmt.setString(6, obj.getDescription());
				pstmt.setString(7, obj.getLacation());
				pstmt.setTime(8, obj.getSubmissionTime());

				int count = pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				rs.next();
				int requestId = rs.getInt(1);
				obj.setRequestId(requestId);

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

		return obj.getRequestId();

	}

	@Override
	public ReimbursementRequests getById(int requestId) {
		ReimbursementRequests reimbRequest = new ReimbursementRequests();
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;

		String sql = "SELECT * FROM ReimbursementRequests where requestId=?";
		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, requestId);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					reimbRequest = parseResulset(rs);


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
		return reimbRequest;
	}

	@Override
	public List <ReimbursementRequests> getByEmployeeId(int employeeId) {

		List <ReimbursementRequests> userRequests = new ArrayList<ReimbursementRequests>() ;
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;

		String sql = "SELECT * FROM ReimbursementRequests where employeeId=?";
		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, employeeId);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					ReimbursementRequests reimbRequest = parseResulset(rs);
					reimbRequest = parseResulset(rs);
					userRequests.add(reimbRequest);

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
		return userRequests;
	}

	@Override
	public int update(ReimbursementRequests obj) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "UPDATE  ReimbursementRequests SET employeeId =?, eventTypeId =?,statusId =?,"
				+ "eventCost =? eventDate =?,description =?,submissionTime =? WHERE RequestId =?";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, obj.getEmployeeId());
				pstmt.setInt(2, obj.getEventTypeId());
				pstmt.setInt(3, obj.getStatusId());
				pstmt.setDouble(4, obj.getCost());
				pstmt.setDate(4, obj.getEventDate());
				pstmt.setString(5, obj.getDescription());
				pstmt.setTime(6, obj.getSubmissionTime());
				pstmt.setString(7, obj.getLacation());
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

		String sql = "DELETE FROM ReimbursementRequest where requestid =?; ";

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
