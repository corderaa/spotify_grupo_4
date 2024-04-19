package spotifyGrupo4.db.POJO;

import java.util.Date;
import java.util.Objects;

public class Serie {
	private int id = 0;
	private Date startingDate = null;
	private Date finishDate = null;
	private String theme = null;
	private String title = null;
	private String description = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, finishDate, id, startingDate, theme, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(description, other.description) && Objects.equals(finishDate, other.finishDate)
				&& id == other.id && Objects.equals(startingDate, other.startingDate)
				&& Objects.equals(theme, other.theme) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", startingDate=" + startingDate + ", finishDate=" + finishDate + ", theme=" + theme
				+ ", title=" + title + ", description=" + description + "]";
	}

}
