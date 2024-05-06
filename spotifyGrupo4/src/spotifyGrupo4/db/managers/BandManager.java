package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

public class BandManager implements ContentInterface<Band>, InterfaceManager<Band> {
	private final String DELETE_BAND_BY_ID = "delete from band where contentCreatorId = 1;";
	private final String GET_ONE_BAND = "SELECT * FROM band WHERE podcasterId = ?";
	private final String GET_ALL_BANDS = "SELECT * from band b join contentcreator c using (contentCreatorId)";

	@Override
	public List<Band> getAll() {
		ArrayList<Band> ret = null;

		String sql = GET_ALL_BANDS;

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
					ret = new ArrayList<Band>();

				spotifyGrupo4.db.pojo.Band band = new spotifyGrupo4.db.pojo.Band();

				int bandId = resultSet.getInt("bandId");
				int members = resultSet.getInt("members");
				String contentCreatorName = resultSet.getString("contentCreatorName");
				java.sql.Date creationDate = resultSet.getDate("creationDate");
				int numberReproductions = resultSet.getInt("numberReproductions");
				String contentCreatorDescription = resultSet.getString("contentCreatorDescription");
				String contentCreatorImage = resultSet.getString("contentCreatorImage");

				band.setId(bandId);
				band.setMembers(members);
				band.setName(contentCreatorName);
				band.setReproduction(numberReproductions);
				band.setCreationDate(DateConverter.sqlDateToUtilDate(creationDate));
				band.setReproduction(numberReproductions);
				band.setDescription(contentCreatorDescription);
				band.setImage(contentCreatorImage);

				ret.add(band);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
	public void insert(Band band) {
		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into band (members,contentCreatorRegistrationDate,\r\n"
					+ "contentCreatorReproductionNumber,contentCreatorDescription,contentCreatorName, contentCreatorImage) VALUES ('"
					+ band.getMembers() + "', '" + band.getCreationDate() + "', '" + band.getReproduction() + "', '"
					+ band.getDescription() + "', '" + band.getName() + "', '" + band.getImage() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
	public void modify(Band t) {
		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();

			String sql = "update band set members = '" + t.getMembers() + "',contentCreatorRegistrationDate = '"
					+ t.getCreationDate() + "',contentCreatorReproductionNumber = '" + t.getReproduction() + "' , contentCreatorDescription = '" 
					+ t.getDescription() + "',contentCreatorDescription = '" + t.getDescription() + "' where id = " + t.getId();

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
	public void delete(Band t) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = DELETE_BAND_BY_ID;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
	public Band getOne(Band podcasterId) {
		Band band = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = GET_ONE_BAND;
			statement = connection.prepareStatement(sql);
			statement.setObject(1, podcasterId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				band = new Band();
				band.setId(resultSet.getInt("podcasterId"));
				band.setMembers(resultSet.getInt("bandMembers"));
				band.setReproduction(resultSet.getInt("reproduction"));
				band.setDescription(resultSet.getString("description"));
				band.setName(resultSet.getString("name"));
				band.setImage(resultSet.getString("image"));
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
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
		return band;
	}
}
