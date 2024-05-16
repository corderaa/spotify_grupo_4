package spotifyGrupo4.db.managers;

import java.sql.SQLException;

public interface ContentInterface<T> {

	/**
	 * Modifies table from the database
	 * 
	 * @param t
	 * @throws Exception
	 * @throws SQLException
	 */
	public void modify(T t) throws SQLException, Exception;

	/**
	 * Deletes a Row from the database
	 * 
	 * @param t
	 */
	public void delete(T t);

}
