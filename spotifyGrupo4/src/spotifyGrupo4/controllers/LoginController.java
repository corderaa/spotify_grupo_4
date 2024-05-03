package spotifyGrupo4.controllers;

import java.util.List;

import spotifyGrupo4.db.managers.FreeAccountManager;
import spotifyGrupo4.db.pojo.Account;

public class LoginController implements ControllerInterface<Account> {
	
	private FreeAccountManager freeAccountManager = null;

	public LoginController() {
		freeAccountManager = new FreeAccountManager();
	}

	/**
	 * Method that validates the login, it takes the input for the password and the
	 * account the user is trying to log in and compares the passwords.
	 * 
	 * @param password intput from the user
	 * @param t        account the user is trying to log in
	 * @return true if the two passwords are the same, false if the passwords are
	 *         not the same
	 */
	public boolean validateLogin(String password, Account t) {

		return false;
	}

	@Override
	public void insert(Account t) {
		freeAccountManager.insert(freeAccountManager.getByLogin(t.getDni()));

	}

	@Override
	public void update(Account t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Account t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
