package spotifyGrupo4.controllers;

import java.io.FileNotFoundException;
import java.sql.Connection;
import spotifyGrupo4.db.managers.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.FileManager;
import spotifyGrupo4.db.pojo.Content;
import spotifyGrupo4.db.pojo.Playlist;
import spotifyGrupo4.db.pojo.Podcast;
import spotifyGrupo4.db.pojo.Song;

// RUTA = .//ficheros

public class PlaylistController  {

	/**
	 * This method retrieves a lists of the lists created by one user, and stores it in a newlycreated file
	 * with the number of the account as a name.
	 * @param accountId
	 * @throws Exception
	 * @throws SQLException
	 */
	public void exportPlaylistBackUp(int accountId) throws Exception, SQLException, FileNotFoundException {
		PlayListManager playListManager = new PlayListManager();
		FileManager fileManager = new FileManager();
		//playListManager.getAllToExport(accountId);
		//se recibe un OBjeto que es resultset, sin tratar, y envia al file manager
		//el acocuntid, se sumara despues a la ruta, para que se cree un back up con cada cuenta
		fileManager.writeObject(playListManager.getAllPlaylistsFromUser(accountId), String.valueOf(accountId));
			
	}
	/**
	 * It will retrieve from a file, the back up in the form of a List
	 * @param accountId
	 * @return
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Playlist> importPlaylistBackUp(int accountId)  throws FileNotFoundException, Exception
	{
		return (List<Playlist>)(new FileManager().readObject(String.valueOf(accountId)));

	}
	
	
	public ArrayList<Playlist>  getAllPlaylistsFromAccount(int accounId) throws SQLException, Exception {
		
		return  (new PlayListManager().getAllPlaylistsFromUser( accounId));
	}
	
	
	public void erase(int playlistId) throws SQLException, Exception {
		new PlayListManager().delete(playlistId);
		
	}
	
	public void makeNewPlaylist(int accountId, String title) throws SQLException, Exception {
		
		new PlayListManager().createPlaylist( accountId,  title);
	}
	
	public ArrayList<Content> getOneListContent(int playlistId) throws SQLException, Exception
	{
		return (new PlayListManager().getListContent(playlistId));
	}

}
