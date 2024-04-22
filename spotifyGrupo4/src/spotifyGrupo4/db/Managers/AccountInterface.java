package spotifyGrupo4.db.Managers;

import java.util.Date;

public interface AccountInterface<T> extends InterfaceManager<T> {

	/**
	 * Gets the account by the login
	 * 
	 * @param login
	 */
	public T ByLogin(String login);

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
	 */
	public void updatePassword(T t, String password);
}
