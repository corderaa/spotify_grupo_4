package spotifyGrupo4.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javazoom.jl.player.Player;
import spotifyGrupo4.db.managers.PodcastManager;
import spotifyGrupo4.db.managers.SongManager;
import spotifyGrupo4.db.pojo.Content;
import spotifyGrupo4.db.pojo.Podcast;
import spotifyGrupo4.db.pojo.Song;

public class AudioController {

	public static AudioController instance = null;
	private final String directoryPath = ".//music//";
	private int currentAudioIndex = 0;
	private Player player = null;
	private SongManager songManager = null;
	private PodcastManager podcastManager = null;

	/**
	 * List of content waiting to be played
	 */
	public List<String> audioFileNames = null;

	public AudioController() {
		songManager = new SongManager();
		audioFileNames = loadAudioFilesArray();
		podcastManager = new PodcastManager();
	}

	public static AudioController getInstance() {
		return instance = null == instance ? new AudioController() : instance;
	}

	/**
	 * When called ads a reproduction to the content being played
	 * 
	 * @param content the song or podcast
	 * @throws Exception
	 * @throws SQLException
	 */
	public void addReproduction(Content content) throws SQLException, Exception {
		if (Session.getInstance().getSelectedContent().getContentType().equals("single")) {
			songManager.addReproduction((Song) content);
		} else if (Session.getInstance().getSelectedContent().getContentType().equals("podcast")) {
			podcastManager.addReproduction((Podcast) content);
		}
	}

	/**
	 * Hace sonar la cancion
	 */
	public void playContent() {

		if (null != audioFileNames) {

			new Thread() {
				@Override
				public void run() {
					try {
						FileInputStream fileInputStream = new FileInputStream(
								directoryPath + audioFileNames.get(currentAudioIndex));
						player = new Player(fileInputStream);
						player.play();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}.start();
		}
	}

	/**
	 * Detiene la musica
	 */
	public void stopContent() {
		if (player != null) {
			player.close();
		}
	}

	public void changeNextContent() {
		stopContent();

		if (currentAudioIndex < audioFileNames.size() - 1) {
			currentAudioIndex++;
		} else {
			currentAudioIndex = 0;
		}

		playContent();
	}

	public void changePreviusContent() {
		stopContent();

		if (currentAudioIndex > 0) {
			currentAudioIndex--;
		} else {
			currentAudioIndex = audioFileNames.size() - 1;
		}

		playContent();
	}

	private List<String> loadAudioFilesArray() {
		List<String> ret = null;

		File directory = new File(directoryPath);
		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				ret = null == ret ? new ArrayList<String>() : ret;
				ret.add(file.getName());
			}
		}
		return ret;
	}

	public List<String> getContents() {
		return audioFileNames;
	}

	public void setContents(List<String> audioFiles) {
		this.audioFileNames = audioFiles;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<String> getAudioFileNames() {
		return audioFileNames;
	}

	public void setAudioFileNames(List<String> audioFileNames) {
		this.audioFileNames = audioFileNames;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public static void setInstance(AudioController instance) {
		AudioController.instance = instance;
	}
}
