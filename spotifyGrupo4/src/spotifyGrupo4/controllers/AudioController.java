package spotifyGrupo4.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javazoom.jl.player.Player;
import spotifyGrupo4.db.pojo.Content;

public class AudioController {

	public static AudioController instance = null;
	private final String directoryPath = ".//music//";
	private int currentAudioIndex = 0;
	private Player player = null;

	/**
	 * List of content waiting to be played
	 */
	public List<String> audioFileNames = null;

	public AudioController() {
		audioFileNames = loadAudioFilesArray();
	}

	public static AudioController getInstance() {
		return instance = null == instance ? new AudioController() : instance;
	}

	/**
	 * When called ads a reproduction to the content being played
	 * 
	 * @param content the song or podcast
	 */
	public void addReproduction(Content content) {

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
				System.out.println(file.getName());
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
