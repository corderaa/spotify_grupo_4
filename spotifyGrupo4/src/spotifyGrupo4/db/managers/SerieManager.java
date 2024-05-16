package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.pojo.Podcaster;
import spotifyGrupo4.db.pojo.Record;
import spotifyGrupo4.db.pojo.Serie;
import spotifyGrupo4.db.utils.DBUtils;

public class SerieManager implements ContentInterface<Serie>, InterfaceManager<Serie> {

	private static final String GET_SERIES_FROM_PODCASTER = "SELECT * FROM reto4_grupo4.serie s join podcaster p on podcasterId = contentCreatorId where contentCreatorId = ?";

	public List<Serie> getSeriesFromPodcaster(Podcaster podcaster) throws ClassNotFoundException, SQLException {

		ArrayList<Serie> ret = new ArrayList<Serie>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = GET_SERIES_FROM_PODCASTER;
			statement = connection.prepareStatement(sql);
			statement.setObject(1, podcaster.getId());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				spotifyGrupo4.db.pojo.Serie serie = new spotifyGrupo4.db.pojo.Serie();
				serie.setId(resultSet.getInt("serieId"));
				serie.setTitle(resultSet.getString("title"));
				serie.setStartingDate(resultSet.getDate("firstEpisodeDate"));
				serie.setFinishDate(resultSet.getDate("lastEpisodeDate"));
				serie.setTheme(resultSet.getString("theme"));
				serie.setDescription(resultSet.getString("description"));
				ret.add(serie);
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
		return ret;
	}

	@Override
	public List<Serie> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Serie t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Serie t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Serie t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Serie getOne(Serie t) {
		// TODO Auto-generated method stub
		return null;
	}

}
