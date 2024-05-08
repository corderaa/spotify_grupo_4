package spotifyGrupo4.controllers;

import java.sql.SQLException;

import javax.swing.JTextField;

import spotifyGrupo4.db.managers.FreeAccountManager;
import spotifyGrupo4.db.managers.PremiumAccountManager;
import spotifyGrupo4.db.pojo.Account;

/**
 * Singleton pattern ensure one and only one instance of the same object is
 * created. If null it creates a new one, else, it will return always the same
 * instance, untill we nullify and do it again.
 */
public class Session {

	public static Session instance = null;

	/**
	 * List of content waiting to be played
	 */
	private Account account = null;

	private FreeAccountManager freeAccountManager = null;
	private PremiumAccountManager premiumAccountManager = null;

	private Session() {
		freeAccountManager = new FreeAccountManager();
		premiumAccountManager = new PremiumAccountManager();
	}

	public static Session getInstance() {
		return instance = null == instance ? new Session() : instance;
	}

	public Account getAccount() {

		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void updatePassword(Account account, JTextField password1) throws SQLException, Exception {
		if (null != account) {
			if (account.getAccountType().equalsIgnoreCase("Free")) {
				freeAccountManager.updatePassword(freeAccountManager.getByLogin(account), password1.getText());
			} else if (account.getAccountType().equalsIgnoreCase("Premium")) {
				premiumAccountManager.updatePassword(premiumAccountManager.getByLogin(account), password1.getText());
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
}
