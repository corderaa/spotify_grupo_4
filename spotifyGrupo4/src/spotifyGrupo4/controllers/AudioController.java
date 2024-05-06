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
	private String MUSIC_FILE = null;
	private Player player = null;

	/**
	 * List of content waiting to be played
	 */
	public List<String> audioFiles = null;

	public AudioController() {
		audioFiles = new ArrayList<String>();
		loadAudioFilesArray();
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

		if (MUSIC_FILE == null) {
			MUSIC_FILE = audioFiles.get(0);
		}

		new Thread() {

			@Override
			public void run() {

				try {
					FileInputStream fileInputStream = new FileInputStream(directoryPath + MUSIC_FILE);
					player = new Player(fileInputStream);
					player.play();
				} catch (Exception e) {
					// TODO: think about how to propagate
				}
			}
		}.start();
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

		for (int i = 0; i < audioFiles.size(); i++) {
			if (MUSIC_FILE.equals(audioFiles.get(i))) {
				if (i == audioFiles.size() + 1) {
					MUSIC_FILE = audioFiles.get(0);
				} else {
					MUSIC_FILE = audioFiles.get(i++);
				}
			}
		}

		playContent();
	}

	public void changePreviusContent() {
		stopContent();

		for (int i = 0; i < audioFiles.size(); i++) {
			if (MUSIC_FILE.equals(audioFiles.get(i))) {
				if (i == 0) {
					MUSIC_FILE = audioFiles.get(audioFiles.size() - 1);
				} else {
					MUSIC_FILE = audioFiles.get(i--);
				}
			}
		}

		playContent();
	}

	private void loadAudioFilesArray() {

		File directory = new File(directoryPath);
		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				audioFiles.add(file.getName());
			}
		}
	}

	public List<String> getContents() {
		return audioFiles;
	}

	public void setContents(List<String> audioFiles) {
		this.audioFiles = audioFiles;
	}
}
