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
		reimbRequest.setRequestId(rs.getInt(0));
		reimbRequest.setEmployeeId(rs.getInt(1));
		reimbRequest.setEventTypeId(rs.getInt(2));
		reimbRequest.setStatusId(rs.getInt(3));
		reimbRequest.setCost(rs.getDouble(4));
		reimbRequest.setEventDate(rs.getDate(5));
		reimbRequest.setDescription(rs.getNString(6));
		reimbRequest.setLacation(rs.getString(7));
		reimbRequest.setSubmissionTime(rs.getDate(8));

		return reimbRequest;
	}

	@Override
	public int create(ReimbursementRequests obj) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO ReimbursementRequests(requestId, employeeId, eventTypeId,statusId,"
				+ "eventDate,description,submissionTime)" + "VALUES (default,?,?,?,?,?,?)";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, obj.getEmployeeId());
				pstmt.setInt(2, obj.getEventTypeId());
				pstmt.setInt(3, obj.getStatusId());
				pstmt.setDate(4, obj.getEventDate());
				pstmt.setString(0, obj.getDescription());
				pstmt.setDate(0, obj.getSubmissionTime());
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
	public ReimbursementRequests getById(int reimbursementRequestId) {

		return null;
	}

	@Override
	public int update(ReimbursementRequests obj) {
		return 0;
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteteById(int id) {
		// TODO Auto-generated method stub

	}

}
