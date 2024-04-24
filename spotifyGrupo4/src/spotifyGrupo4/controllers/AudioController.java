package spotifyGrupo4.controllers;

import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.pojo.Content;

public class AudioController {

	public static AudioController instance = null;

	/**
	 * List of content waiting to be played
	 */
	public List<Content> contents = null;

	public AudioController() {
		contents = new ArrayList<Content>();
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

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

}
