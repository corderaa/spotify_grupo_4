package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import spotifyGrupo4.db.pojo.Content;
import spotifyGrupo4.db.pojo.Playlist;
import spotifyGrupo4.db.pojo.Podcast;
import spotifyGrupo4.db.pojo.Song;
import spotifyGrupo4.db.utils.DBUtils;

public class PlayListManager {

	/**
	 * Deletes a playList from the database
	 * 
	 * @param t
	 */
	public void delete( int playlistId) throws SQLException, Exception {

		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		sql = "delete from playlist where playlistId = " + playlistId + " and borrable = 1";
		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		}  catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
		finally {
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

	public void createFirstPlaylist(int accountId) throws Exception, SQLException {
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			String sql = "insert into playlist values (default," + accountId + ",'favourites', 0)";
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
		finally {
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
	 * it calls a procedure that evaluates whether the user is free and has not yet
	 * reached.
	 * 
	 * @param accountId
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createPlaylist(int accountId, String title) throws Exception, SQLException {

		String sql = "call insertPlaylist(" + accountId + ",'"+ title + "')";

	
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		try {
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			preparedStatement = connection.prepareStatement(sql);
			Class.forName(DBUtils.DRIVER);
			preparedStatement.executeUpdate();
		} 	 catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
		finally {
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
	 * it retrieves all the Palylistes belonging to an accountId.
	 * notice one of the atributes of Playlist is an list on contents, hence it calls a function to fill up such list.
	 * @param accounId
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ArrayList<Playlist> getAllPlaylistsFromUser(int accounId) throws Exception, SQLException {

		String sql = "select * from playlist where playlist.accountId =  " + accounId ;
		ArrayList<Playlist> allPlaylists = new ArrayList<>();
		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);
		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		// resultSet = statement.executeQuery(GET_USER_PLAYLISTS);
	
		while (resultSet.next()) {

			ArrayList<Content> contentInList = new ArrayList<Content>();
			Playlist newPlaylist = new Playlist();
			newPlaylist.setAccount(null);
			newPlaylist.setTitle(resultSet.getString("playlistTitle"));
			newPlaylist.setPlaylistId(resultSet.getInt("playlistId"));
			contentInList = getListContent(newPlaylist.getPlaylistId());
			newPlaylist.setContents(contentInList);
			allPlaylists.add(newPlaylist);

		}

		return allPlaylists;
	}

	/**
	 * gicen and id, from the caller funcion getAllPlaylistsFromUser, it loads  and returns an arraylist 
	 * with all the content loaded in the lists
	 * @param playlistId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<Content> getListContent(int playlistId) throws SQLException, Exception
	{
		System.out.println("DEbuging, enterin getListContent");
		///////////////////
		 String sql = "SELECT * from listline  natural join content where playlistId = " + playlistId;
		 ArrayList<Content> allContents = new ArrayList<Content>();
		
		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet resultSet = null;
		
		
		try {Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			 resultSet = statement.executeQuery(sql);
			//resultSet = statement.executeQuery(GET_USER_PLAYLISTS);
			 
			 while (resultSet.next()) {
					
				 if (resultSet.getString("contentType").equalsIgnoreCase("single"))
				 {
					 	Song newContent = new Song();
					 	newContent.setTitle(resultSet.getString("title"));
						newContent.setContentId(resultSet.getInt("playlistId"));
						//newContent.setDuration(resultSet.getDate("Duration"));
						System.out.println(newContent.toString());
						allContents.add(newContent);
					 
				 }
						
				 else if  (resultSet.getString("contentType").equalsIgnoreCase("podcast"))
				 {
					 Podcast newContent = new Podcast();
					 	newContent.setTitle(resultSet.getString("title"));
						newContent.setContentId(resultSet.getInt("playlistId"));
						//newContent.setDuration(resultSet.getDate("Duration"));
						System.out.println(newContent.toString());

						allContents.add(newContent);
					 
				 }
			 }
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
		finally {
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



	/**
	 * It send the query, and evaluates the type of resultset, before creating the
	 * object and loading the list
	 * 
	 * @param accountId
	 * @param playListTitle
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Content> getPlayListContent(int accountId, String playListTitle)
			throws SQLException, ClassNotFoundException {

		String sql = null;

		ArrayList<Content> playListContent = new ArrayList<>();
		sql = "SELECT content.title , content.contentType, content.duration, content.numberReproductions from content join listline on listline.contentId = content.contentId\r\n"
				+ "  join playlist on  playlist.playlistId = listline.playlistId  where playlist.accountId = "
				+ accountId + " and playlist.playlistTitle ='" + playListTitle + "'";

		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet resultSet = null;

		
		try {		
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (resultSet.getString("contentType").equalsIgnoreCase("single") ) {
					Song newSong = new Song();

					newSong.setTitle(resultSet.getString("title"));
					newSong.setContentId(accountId);
					newSong.setReproductions(resultSet.getInt("numberReproductions"));

					// gotta be parsed
					// newContent.setDuration(resultSet.getInt("duration"));

					playListContent.add(newSong);
				} else {
					Podcast newPodcast = new Podcast();
					newPodcast.setContentId(accountId);

					newPodcast.setTitle(resultSet.getString("title"));
					newPodcast.setReproductions(resultSet.getInt("numberReproductions"));

					// newContent.setDuration(resultSet.getInt("duration"));
					// gotta be parsed

					playListContent.add(newPodcast);
				}

			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
		finally {
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
		return playListContent;
	}
}
