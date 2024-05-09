 	package spotifyGrupo4.db.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Playlist implements Serializable{
	
	//Para no quitar un campo que ya estaba creado,
	//he anadido account id, que deberia en realidad susituir a account, 



	private int playlistId = 0;
	private Account account = null;
	private int accountid = 0;
	private String title = null;
	private List<Content> contents = null;
	private String contentType = null;

	
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Playlist() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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
		return Objects.hash(account, accountid, contentType, contents, playlistId, title);
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
		return Objects.equals(account, other.account) && accountid == other.accountid
				&& Objects.equals(contentType, other.contentType) && Objects.equals(contents, other.contents)
				&& playlistId == other.playlistId && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Playlist [playlistId=" + playlistId + ", account=" + account + ", accountid=" + accountid + ", title="
				+ title + ", contents=" + contents + ", contentType=" + contentType + "]";
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

}
