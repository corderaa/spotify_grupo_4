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
import spotifyGrupo4.db.pojo.Content;
import spotifyGrupo4.db.pojo.Podcaster;
import spotifyGrupo4.db.pojo.Record;
import spotifyGrupo4.db.pojo.Song;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

public class SongManager implements ContentInterface<Song>, InterfaceManager<Song> {

	private static final String GET_ALL_SONG_WITH_CONTENT = "SELECT * FROM reto4_grupo4.song join content c using (contentId)";
	private static final String GET_SONG_FROM_RECORDS = null;

	@Override
	public List<Song> getAll() {
		ArrayList<Song> ret = null;

		String sql = GET_ALL_SONG_WITH_CONTENT;

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
					ret = new ArrayList<Song>();

				spotifyGrupo4.db.pojo.Song song = new spotifyGrupo4.db.pojo.Song();

				int contentId = resultSet.getInt("contentId");
				String title = resultSet.getString("title");
				java.sql.Date duration = resultSet.getDate("duration");
				int numberReproductions = resultSet.getInt("numberReproductions");
				String contentType = resultSet.getString("contentType");

				song.setContentId(contentId);
				song.setTitle(title);
				song.setDuration(duration);
				song.setReproductions(numberReproductions);
				song.setContentType(contentType);

				ret.add(song);
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
	public void insert(Song t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Song t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Song t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Song getOne(Song t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Song> getSongsFromRecord(Record record) throws ClassNotFoundException, SQLException {

		ArrayList<Song> ret = new ArrayList<Song>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = GET_SONG_FROM_RECORDS;
			statement = connection.prepareStatement(sql);
			statement.setObject(1, record.getId());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				spotifyGrupo4.db.pojo.Song song = new spotifyGrupo4.db.pojo.Song();

				song.setContentId(resultSet.getInt("contentId"));
				song.setTitle(resultSet.getString("title"));
				song.setDuration(resultSet.getDate("duration"));
				song.setReproductions(resultSet.getInt("numberReproductions"));
				song.setContentType(resultSet.getString("contentType"));
				ret.add(song);
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
}
