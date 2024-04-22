package spotifyGrupo4.db.pojo;

import java.util.Date;
import java.util.Objects;

public class Record {

	private int Id = 0;
	private String title = null;
	private Date releaseDate = null;
	private String genre = null;
	private String recordCover = null;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRecordCover() {
		return recordCover;
	}

	public void setRecordCover(String recordCover) {
		this.recordCover = recordCover;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, genre, recordCover, releaseDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		return Id == other.Id && Objects.equals(genre, other.genre) && Objects.equals(recordCover, other.recordCover)
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Record [Id=" + Id + ", title=" + title + ", releaseDate=" + releaseDate + ", genre=" + genre
				+ ", recordCover=" + recordCover + "]";
	}

}
