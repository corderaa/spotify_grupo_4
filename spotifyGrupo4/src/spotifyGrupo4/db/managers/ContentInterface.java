package spotifyGrupo4.db.managers;

public interface ContentInterface<T> {

	/**
	 * Modifies table from the database
	 * 
	 * @param t
	 */
	public void modify(T t);

	/**
	 * Deletes a Row from the database
	 * 
	 * @param t
	 */
	public void delete(T t);

}
