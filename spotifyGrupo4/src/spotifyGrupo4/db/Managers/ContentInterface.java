package spotifyGrupo4.db.Managers;

public interface ContentInterface<T> extends InterfaceManager<T> {

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
