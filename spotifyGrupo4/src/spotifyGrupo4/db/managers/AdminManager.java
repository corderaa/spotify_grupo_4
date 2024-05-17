package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.utils.DBUtils;

public class AdminManager {

//		I came up with this of using a case when, 
//		so the attribute will be inmediatly assigned , considering its position in the cell

	/**
	 * Deletes a playList from the database
	 * 
	 * @param t
	 */
	public void delete(int creatorId) throws SQLException, Exception {

		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		sql = "delete from contentcreator where contentCreatorId = " + creatorId;
		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
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

	/**
	 * it creates a new creator, the procedure shall diffrenciate if handling a band
	 * or a group itself, using the numbers of members as an indicator and taking
	 * the max(creatorid, as to match the band/podacaster later on)
	 * 
	 * @param accountId
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addCreator(String arg_bandName, String arg_Formation, String arg_About, String pathImage,
			int arg_members) throws Exception, SQLException {

		String sql = null;
		if (pathImage != null)
			sql = "call insertCreator('" + arg_bandName + "','" + arg_Formation + "' ,'" + arg_About + "','" + pathImage
					+ "', " + arg_members + ")";
		else
			sql = "call insertCreator('" + arg_bandName + "','" + arg_Formation + "' ,'" + arg_About + "',null, "
					+ arg_members + ")";

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			preparedStatement = connection.prepareStatement(sql);
			Class.forName(DBUtils.DRIVER);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
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

	//
	/**
	 * it retrieves all the Palylistes belonging to an accountId. notice one of the
	 * atributes of Playlist is an list on contents, hence it calls a function to
	 * fill up such list.
	 * 
	 * @param accounId
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ArrayList<Band> getAllCreators() throws Exception, SQLException {

		String sql = "select * from contentcreator";
		ArrayList<Band> allPlaylists = new ArrayList<>();
		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {

			Band newBand = new Band();
			newBand.setName(resultSet.getString("contentCreatorName"));
			newBand.setId(resultSet.getInt("contentCreatorId"));
			newBand.setReproduction(resultSet.getInt("contentCreatorReproductionNumber"));
			newBand.setDescription(resultSet.getString("contentCreatorDescription"));
			allPlaylists.add(newBand);

		}

		return allPlaylists;
	}

	/**
	 * gicen and id, from the caller funcion getAllPlaylistsFromUser, it loads and
	 * returns an arraylist with all the content loaded in the lists
	 * 
	 * @param playlistId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<Band> getFavourites() throws SQLException, Exception {

		String sql = "SELECT nombre, favourited from  infocreatorstats order by favourited desc limit 10";
		ArrayList<Band> allContents = new ArrayList<Band>();

		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Band newContent = new Band();
				newContent.setName(resultSet.getString("nombre"));
				newContent.setId(resultSet.getInt("favourited"));
				allContents.add(newContent);
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
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
		return allContents;
	}

	public ArrayList<Band> getMostViewed() throws SQLException, Exception {

		String sql = "SELECT nombre, totalReproductions from  infocreatorstats order by totalReproductions desc limit 10";
		ArrayList<Band> allContents = new ArrayList<Band>();

		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Band newContent = new Band();
				newContent.setName(resultSet.getString("nombre"));
				newContent.setId(resultSet.getInt("totalReproductions"));
				allContents.add(newContent);
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
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
		return allContents;
	}
}
