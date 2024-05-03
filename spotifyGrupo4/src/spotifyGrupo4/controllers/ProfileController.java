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

		return freeAccountManager.getbyLogin(id);
	}

	public PremiumAccount getPremiumByLogin(String id) throws SQLException, Exception {

		return premiumAccountManager.getbyLogin(id);
	}

	public void updatePassword(Account account, JTextField password1) throws SQLException, Exception {
		if (null != account) {
			if (account.getAccountType() == "Premium") {
				freeAccountManager.updatePassword(freeAccountManager.getbyLogin(account.getDni()), password1.getText());
			} else if (account.getAccountType() == "Free") {
				premiumAccountManager.updatePassword(premiumAccountManager.getbyLogin(account.getDni()),
						password1.getText());
			}
		}
	}

	public boolean isPasswordValid(JTextField password1, JTextField password2) {
		if (!(password1.getText().isEmpty()) && !(password2.getText().isBlank())
				&& (password1.getText().equals(password2.getText()) && hasPasswordLowerCaseCharacter(password1)
						&& hasPasswordNumber(password1) && hasPasswordUpperCaseCharacter(password1)
						&& password1.getText().length() > 6)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean hasPasswordUpperCaseCharacter(JTextField password1) {
		int count = 0;
		for (int i = 0; i < password1.getText().length(); i++) {
			if (Character.isUpperCase(password1.getText().charAt(i))) {
				count++;
			}
		}

		return count > 0 ? true : false;
	}

	private boolean hasPasswordLowerCaseCharacter(JTextField password1) {
		int count = 0;
		for (int i = 0; i < password1.getText().length(); i++) {
			if (Character.isLowerCase(password1.getText().charAt(i))) {
				count++;
			}
		}

		return count > 0 ? true : false;
	}

	private boolean hasPasswordNumber(JTextField password1) {
		int count = 0;
		for (int i = 0; i < password1.getText().length(); i++) {
			if (Character.isDigit(password1.getText().charAt(i))) {
				count++;
			}
		}

		return count > 0 ? true : false;
	}
}
