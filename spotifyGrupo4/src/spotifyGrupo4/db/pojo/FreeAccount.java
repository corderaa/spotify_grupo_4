package spotifyGrupo4.db.pojo;

import java.util.Date;
import java.util.Objects;

public class FreeAccount extends Account {

	private Date lastListenedContent = null;

	public Date getLastListenedContent() {
		return lastListenedContent;
	}

	public void setLastListenedContent(Date lastListenedContent) {
		this.lastListenedContent = lastListenedContent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(lastListenedContent);
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
		FreeAccount other = (FreeAccount) obj;
		return Objects.equals(lastListenedContent, other.lastListenedContent);
	}

	@Override
	public String toString() {
		return "FreeAccount [lastListenedContent=" + lastListenedContent + "]";
	}

}
