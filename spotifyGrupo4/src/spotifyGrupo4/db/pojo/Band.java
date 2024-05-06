package spotifyGrupo4.db.pojo;

import java.util.Date;
import java.util.Objects;

public class Band extends ContentCreator {

	private int ContentCreatorId = 0;
	private Date creationDate = null;
	private int members = 0;

	public Integer getContentCreatorId() {
		return ContentCreatorId;
	}

	public void setContentCreatorId(Integer contentCreatorId) {
		ContentCreatorId = contentCreatorId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ContentCreatorId, creationDate, members);
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
		Band other = (Band) obj;
		return Objects.equals(ContentCreatorId, other.ContentCreatorId)
				&& Objects.equals(creationDate, other.creationDate) && members == other.members;
	}

	@Override
	public String toString() {
		return "Band [ContentCreatorId=" + ContentCreatorId + ", creationDate=" + creationDate + ", members=" + members
				+ "]";
	}

}
