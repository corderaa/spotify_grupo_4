package spotifyGrupo4.controllers;

import java.util.List;

import spotifyGrupo4.db.managers.FreeAccountManager;
import spotifyGrupo4.db.pojo.Account;

public class LoginController implements ControllerInterface<Account> {

	private FreeAccountManager freeAccountManager = null;

	public LoginController() {
		freeAccountManager = new FreeAccountManager();
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
