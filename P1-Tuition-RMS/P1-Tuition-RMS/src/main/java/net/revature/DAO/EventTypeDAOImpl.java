package net.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.revature.model.EventTypes;

public class EventTypeDAOImpl implements EventTypeDAO {

	@Override
	public List<EventTypes> getAll() {

		List<EventTypes> eventTypes = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EVENTTYPES";

		try {
			connection = DAOConnectionUtilities.getConnection();
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery(); // execute query
			// get resultSet from query and parse to object
			while (rs.next()) {
				EventTypes eventType = parseResulset(rs);
				eventTypes.add(eventType);
				for (EventTypes d : eventTypes) {
					System.out.println(d);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eventTypes;
	}

	private EventTypes parseResulset(ResultSet rs) throws SQLException {

		EventTypes eventType = new EventTypes();
		eventType.setEventTypeId(rs.getInt(1));
		eventType.setEventTypeName(rs.getString(2));
		return eventType;
	}

	@Override
	public int create(EventTypes obj) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "INSERT INTO EVENTTYPES (eventTypeId, EventTypeName)" + "VALUES (default,?)";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement((sql), PreparedStatement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, obj.getEventTypeName());
				count = pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();

				rs.next();
				int eventTypeId = rs.getInt(1);
				obj.setEventTypeId(eventTypeId);

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
	public EventTypes getById(int id) {
		EventTypes eventType = new EventTypes();
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;

		String sql = "SELECT * FROM EVENTTYPES where eventTypeId=?";
		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					eventType = parseResulset(rs);

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
		return eventType;

	}

	@Override
	public int update(EventTypes obj) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "Update EventTypes set eventTypeName =? where eventTypeId =?)";

		if (connection == null) {
			connection = DAOConnectionUtilities.getConnection();
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, obj.getEventTypeName());
				pstmt.setInt(2, obj.getEventTypeId());
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

		String sql = "DELETE FROM EventTypes where eventTypeId =?; ";

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
