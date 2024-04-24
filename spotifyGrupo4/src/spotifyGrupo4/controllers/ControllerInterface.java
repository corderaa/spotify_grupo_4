package spotifyGrupo4.controllers;

import java.util.List;

public interface ControllerInterface<T> {

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

	/**
	 * Updates the object to the database
	 * 
	 * @param t
	 */
	public void update(T t);

	/**
	 * Deletes the object to the database
	 * 
	 * @param t
	 */
	public void delete(T t);

}
