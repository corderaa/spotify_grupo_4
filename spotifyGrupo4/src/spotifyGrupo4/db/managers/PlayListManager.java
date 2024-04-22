package spotifyGrupo4.db.managers;

import java.util.List;

import spotifyGrupo4.db.pojo.Playlist;
import spotifyGrupo4.db.pojo.Podcast;
import spotifyGrupo4.db.pojo.Song;

public class PlayListManager implements InterfaceManager<Playlist> {

	@Override
	public List<Playlist> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Playlist t) {
		// TODO Auto-generated method stub

	}

	/**
	 * Deletes a playList from the database
	 * 
	 * @param t
	 */
	public void delete(Playlist t) {

	}

	/**
	 * Gets the songs from a playList
	 * 
	 * @param playlist
	 * @return
	 */
	public List<Song> getPlaylistSongs(Playlist playlist) {
		return null;
	}

	/**
	 * Gets the podcasts from a playList
	 * 
	 * @param playlist
	 * @return
	 */
	public List<Podcast> getPlayListPodcasts(Playlist playlist) {
		return null;
	}

}
