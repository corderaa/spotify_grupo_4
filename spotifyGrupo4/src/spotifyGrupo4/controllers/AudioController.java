package spotifyGrupo4.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javazoom.jl.player.Player;
import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.Content;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.PremiumAccount;

public class AudioController {

	public static AudioController instance = null;
	private final String directoryPath = ".//music//";
	private String currentFileName = null;
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

			if (null == currentFileName) {
				currentFileName = audioFileNames.get(0);
			}

			new Thread() {
				@Override
				public void run() {
					try {
						FileInputStream fileInputStream = new FileInputStream(directoryPath + currentFileName);
						player = new Player(fileInputStream);
						player.play();
					} catch (Exception e) {

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

		for (int i = 0; i < audioFileNames.size() - 1; i++) {
			if (audioFileNames.get(i).equals(currentFileName)) {
				if (i == audioFileNames.size()) {
					currentFileName = audioFileNames.get(0);
				} else {
					currentFileName = audioFileNames.get(i + 1);
				}
			}
		}
		playContent();
	}

	public void changePreviusContent() {
		stopContent();

		ListIterator<String> iterator = audioFileNames.listIterator();
		for (int i = 0; i < audioFileNames.size(); i++) {
			if (currentFileName.equals(audioFileNames.get(i))) {
				if (i == 0) {
					currentFileName = audioFileNames.get(audioFileNames.size() - 1);
				} else {
					currentFileName = iterator.next();
				}
			}
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

	public void getNext() {

		stopContent();

		for (int i = 0; i < audioFileNames.size() - 1; i++) {
			int idx = audioFileNames.indexOf(currentFileName);
			if (idx < 0 || idx + 1 != audioFileNames.size()) {
				currentFileName = audioFileNames.get(idx + 1);
			}

		}
		playContent();
	}

	public String getPrevious(String uid) {
		int idx = audioFileNames.indexOf(uid);
		if (idx <= 0)
			return "";
		return audioFileNames.get(idx - 1);
	}
}
