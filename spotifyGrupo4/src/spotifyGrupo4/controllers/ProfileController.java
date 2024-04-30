package spotifyGrupo4.controllers;

import java.sql.SQLException;

import spotifyGrupo4.db.managers.FreeAccountManager;
import spotifyGrupo4.db.pojo.FreeAccount;

public class ProfileController {
	private FreeAccountManager freeAccountManager;

	public ProfileController() {
		freeAccountManager = new FreeAccountManager();
	}

	public FreeAccount getbyLogin(String login) throws SQLException, Exception {

		return freeAccountManager.getbyLogin(login);
	}
}
