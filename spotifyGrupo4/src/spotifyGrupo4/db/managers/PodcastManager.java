package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.pojo.Podcast;
import spotifyGrupo4.db.pojo.Serie;
import spotifyGrupo4.db.utils.DBUtils;

public class PodcastManager implements InterfaceManager<Podcast> {
	private static final String GET_PODCAST_FROM_SERIES = "SELECT * FROM reto4_grupo4.podcast p join content c on c.contentId = p.contentId where serieId = ?";

	public List<Podcast> getPodcastFromSeries(Serie serie) throws ClassNotFoundException, SQLException {

		ArrayList<Podcast> ret = new ArrayList<Podcast>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = GET_PODCAST_FROM_SERIES;
			statement = connection.prepareStatement(sql);
			statement.setObject(1, serie.getId());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				spotifyGrupo4.db.pojo.Podcast podcast = new spotifyGrupo4.db.pojo.Podcast();

				podcast.setContentId(resultSet.getInt("contentId"));
				podcast.setTitle(resultSet.getString("title"));
				podcast.setDuration(resultSet.getDate("duration"));
				podcast.setReproductions(resultSet.getInt("numberReproductions"));
				podcast.setContentType(resultSet.getString("contentType"));
				ret.add(podcast);
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
		return ret;
	}

	public void addReproduction(Podcast t) throws SQLException, Exception {

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		PreparedStatement preparedStatement = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Montamos la SQL. Las ? se rellenan a continuacion
			String sql = "update content set numberReproductions = ? where contentId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getReproductions() + 1);
			preparedStatement.setInt(2, t.getContentId());

			// La ejecutamos...
			preparedStatement.executeUpdate();

		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}
	}

	@Override
	public List<Podcast> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Podcast t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Podcast getOne(Podcast t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(Podcast t, String data) throws SQLException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Podcast t) throws SQLException, Exception {
		// TODO Auto-generated method stub

	}

}
