package spotifyGrupo4.db.managers;

import java.sql.SQLException;
import java.util.Date;

import spotifyGrupo4.db.pojo.Account;

public interface AccountInterface<T> {

	/**
	 * Gets the account by the login
	 * 
	 * @param login
	 * @throws Exception
	 * @throws SQLException
	 */
	public T getByLogin(Account account) throws SQLException, Exception;

	/**
	 * Updates the last login of the account to database
	 * 
	 * @param account
	 */
	public void updateLastLogin(T t, Date currentDate);

	/**
	 * Updates isBloqued value of the account to database
	 */
	public void updateIsBloqued(T t, Boolean bloqued);

	/**
	 * Updates the password of an account
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void updatePassword(T t, String password) throws SQLException, Exception;
}
