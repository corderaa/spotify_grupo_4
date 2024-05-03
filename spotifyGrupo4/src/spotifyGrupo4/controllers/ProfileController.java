package spotifyGrupo4.controllers;

import java.sql.SQLException;

import javax.swing.JTextField;

import spotifyGrupo4.db.managers.FreeAccountManager;
import spotifyGrupo4.db.managers.PremiumAccountManager;
import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.PremiumAccount;

public class ProfileController {

	private FreeAccountManager freeAccountManager;
	private PremiumAccountManager premiumAccountManager;

	public ProfileController() {
		freeAccountManager = new FreeAccountManager();
		premiumAccountManager = new PremiumAccountManager();
	}

	public FreeAccount getbyLogin(String id) throws SQLException, Exception {

		return freeAccountManager.getByLogin(id);
	}

	public PremiumAccount getPremiumByLogin(String id) throws SQLException, Exception {

		return premiumAccountManager.getByLogin(id);
	}

}
