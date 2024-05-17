package spotifyGrupo4.db.managers;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceManager<T> {

	/**
	 * Gets all objects from the database
	 * 
	 * @param <T>
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public List<T> getAll() throws SQLException, Exception;

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
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public T getOne(T t) throws SQLException, Exception;
}
