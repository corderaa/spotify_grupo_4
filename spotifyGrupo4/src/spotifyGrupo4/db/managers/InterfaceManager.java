package spotifyGrupo4.db.managers;

import java.sql.SQLException;
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
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void insert(T t) throws SQLException, Exception;

	/**
	 * Search the object to the database
	 * 
	 * @param t
	 */
	public T getOne(T t);
}
