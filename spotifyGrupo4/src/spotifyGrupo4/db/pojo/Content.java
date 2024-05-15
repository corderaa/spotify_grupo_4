package spotifyGrupo4.db.pojo;

import java.util.Date;
import java.util.Objects;

public abstract class Content {
	private int contentId = 0;
	private Date duration = null;
	private String title = null;
	private int reproductions = 0;
	private String contentType = null;

	public int getContentId() {
		return contentId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReproductions() {
		return reproductions;
	}

	public void setReproductions(int reproductions) {
		this.reproductions = reproductions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contentType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		return Objects.equals(contentType, other.contentType);
	}

	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", duration=" + duration + ", title=" + title + ", reproductions="
				+ reproductions + "]";
	}

}
