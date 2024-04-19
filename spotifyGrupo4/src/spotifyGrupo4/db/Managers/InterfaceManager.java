package spotifyGrupo4.db.Managers;

import java.util.List;

public interface InterfaceManager<T> {

	/**
	 * Gets all objects from the database
	 * 
	 * @param <T>
	 * @return
	 */
	public List<T> getAll();

	/**
	 * Inserts the object to the database
	 * 
	 * @param t
	 */
	public void insert(T t);

}
