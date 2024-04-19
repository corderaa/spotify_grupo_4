package spotifyGrupo4.db.POJO;

import java.util.Date;
import java.util.Objects;

public abstract class Content {
	private int contentId = 0;
	private Date duration = null;
	private String title = null;
	private int reproductions = 0;

	public int getContentId() {
		return contentId;
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
		return Objects.hash(contentId, duration, reproductions, title);
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
		return contentId == other.contentId && Objects.equals(duration, other.duration)
				&& reproductions == other.reproductions && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", duration=" + duration + ", title=" + title + ", reproductions="
				+ reproductions + "]";
	}

}
