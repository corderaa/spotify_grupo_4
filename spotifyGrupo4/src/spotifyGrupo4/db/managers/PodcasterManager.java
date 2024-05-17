package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.pojo.Podcaster;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

public class PodcasterManager implements InterfaceManager<Podcaster> {
	private static final String GET_ONE_PODCASTER = "SELECT * FROM podcaster WHERE podcasterId = ?";;
	private static final String GET_ALL_PODCASTERS = "select * from podcaster p join contentcreator c using (contentCreatorId)";
	private static final String DELETE_PODCASTER_BY_ID = "delete from podcaster where contentCreatorId = 1";

	@Override
	public List<Podcaster> getAll() throws SQLException, Exception {
		ArrayList<Podcaster> ret = null;

		String sql = GET_ALL_PODCASTERS;

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Podcaster>();

				spotifyGrupo4.db.pojo.Podcaster podcaster = new spotifyGrupo4.db.pojo.Podcaster();

				int contentCreatorId = resultSet.getInt("contentCreatorId");
				String contentCreatorName = resultSet.getString("contentCreatorName");
				java.sql.Date registrationDate = resultSet.getDate("ContentCreatorRegistrationDate");
				int numberReproductions = resultSet.getInt("ContentCreatorReproductionNumber");
				String contentCreatorDescription = resultSet.getString("contentCreatorDescription");
				String contentCreatorImage = resultSet.getString("contentCreatorImage");

				podcaster.setId(contentCreatorId);
				podcaster.setName(contentCreatorName);
				podcaster.setReproduction(numberReproductions);
				podcaster.setRegistrationDate(DateConverter.sqlDateToUtilDate(registrationDate));
				podcaster.setReproduction(numberReproductions);
				podcaster.setDescription(contentCreatorDescription);
				podcaster.setImage(contentCreatorImage);

				ret.add(podcaster);
			}
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;

	}

	@Override
	public void insert(Podcaster podcaster) throws SQLException, Exception {
		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into contentCreator (contentCreatorName,contentCreatorRegistrationDate) VALUES ('"
					+ podcaster.getName() + "', '" + podcaster.getRegistrationDate() + "')";

			statement.executeUpdate(sql);

		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
	}

	@Override
	public void modify(Podcaster t, String name) throws SQLException, Exception {
		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();

			String sql = "update podcaster set podcastername = '" + name + "',registrationDate = '"
					+ t.getRegistrationDate() + "',contentCreatorReproductionNumber = '" + t.getReproduction()
					+ "' ,  = '" + t.getImage() + "', = image '" + "' where id = " + t.getId();

			statement.executeUpdate(sql);

		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				System.out.println("Error generico - " + e.getMessage());
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				System.out.println("Error generico - " + e.getMessage());
			}
			;
		}

	}

	@Override
	public void delete(Podcaster t) throws SQLException, Exception {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = DELETE_PODCASTER_BY_ID;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getId());

			preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}

	}

	@Override
	public Podcaster getOne(Podcaster podcasterId) throws SQLException, Exception {
		Podcaster podcaster = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = GET_ONE_PODCASTER;
			statement = connection.prepareStatement(sql);
			statement.setObject(1, podcasterId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				podcaster = new Podcaster();
				podcaster.setName(resultSet.getString("podcasterId"));
				podcaster.setRegistrationDate(resultSet.getDate("regritrationDate"));
				podcaster.setReproduction(resultSet.getInt("reproduction"));
				podcaster.setImage(resultSet.getString("image"));
			}
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return podcaster;
	}

}
