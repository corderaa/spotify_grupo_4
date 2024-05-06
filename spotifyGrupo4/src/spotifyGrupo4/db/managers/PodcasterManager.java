package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.pojo.Podcaster;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

public class PodcasterManager implements ContentInterface<Podcaster>, InterfaceManager<Podcaster> {
	private String GET_ALL_PODCASTERS = "select * from podcasters p join contentcreator c using (contentCreatorId)";

	@Override
	public List<Podcaster> getAll() {
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
				int podcasterId = resultSet.getInt("podcasterId");
				String contentCreatorName = resultSet.getString("contentCreatorName");
				java.sql.Date registrationDate = resultSet.getDate("registrationDate");
				int numberReproductions = resultSet.getInt("numberReproductions");
				String contentCreatorDescription = resultSet.getString("contentCreatorDescription");
				String contentCreatorImage = resultSet.getString("contentCreatorImage");

				podcaster.setId(contentCreatorId);
				podcaster.setPodcasterId(podcasterId);
				podcaster.setName(contentCreatorName);
				podcaster.setReproduction(numberReproductions);
				podcaster.setRegistrationDate(DateConverter.sqlDateToUtilDate(registrationDate));
				podcaster.setReproduction(numberReproductions);
				podcaster.setDescription(contentCreatorDescription);
				podcaster.setImage(contentCreatorImage);

				ret.add(podcaster);
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
	public void insert(Podcaster podcaster) {
		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into podcaster (podcasterName,registrationDate,numberReproductions,image) VALUES ('"
					+ podcaster.getName() + "', '" + podcaster.getRegistrationDate() + "', '"
					+ podcaster.getReproduction() + "', '" + podcaster.getImage() + "')";

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
	public void modify(Podcaster t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Podcaster t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Podcaster getOne(Podcaster t) {
		// TODO Auto-generated method stub
		return null;
	}

}
