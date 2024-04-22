package spotifyGrupo4.db.pojo;

import java.util.Objects;

public abstract class ContentCreator {

	private int id = 0;
	private String name = null;
	private String description = null;
	private String image = null;
	private int reproduction = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getReproduction() {
		return reproduction;
	}

	public void setReproduction(int reproduction) {
		this.reproduction = reproduction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, image, name, reproduction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentCreator other = (ContentCreator) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(name, other.name)
				&& reproduction == other.reproduction;
	}

	@Override
	public String toString() {
		return "ContentCreator [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", reproduction=" + reproduction + "]";
	}

}
