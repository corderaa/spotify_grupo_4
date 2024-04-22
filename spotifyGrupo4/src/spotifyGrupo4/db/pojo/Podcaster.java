package spotifyGrupo4.db.pojo;

import java.util.Date;
import java.util.Objects;

public class Podcaster extends ContentCreator {

	private int podcasterId = 0;
	private Date registrationDate = null;

	public int getPodcasterId() {
		return podcasterId;
	}

	public void setPodcasterId(int podcasterId) {
		this.podcasterId = podcasterId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(podcasterId, registrationDate);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Podcaster other = (Podcaster) obj;
		return podcasterId == other.podcasterId && Objects.equals(registrationDate, other.registrationDate);
	}

	@Override
	public String toString() {
		return "Podcaster [podcasterId=" + podcasterId + ", registrationDate=" + registrationDate + "]";
	}

}
