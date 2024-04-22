package spotifyGrupo4.db.pojo;

import java.util.List;
import java.util.Objects;

public class Playlist {

	private int playlistId = 0;
	private Account account = null;
	private List<Content> contents = null;

	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, contents, playlistId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		return Objects.equals(account, other.account) && Objects.equals(contents, other.contents)
				&& playlistId == other.playlistId;
	}

	@Override
	public String toString() {
		return "Playlist [playlistId=" + playlistId + ", account=" + account + ", contents=" + contents + "]";
	}

}
