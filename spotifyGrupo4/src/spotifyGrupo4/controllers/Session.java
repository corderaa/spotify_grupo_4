package spotifyGrupo4.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import spotifyGrupo4.db.managers.AccountManager;
import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.pojo.Record;
import spotifyGrupo4.db.pojo.Serie;
import spotifyGrupo4.db.pojo.Content;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.Podcaster;
import spotifyGrupo4.db.pojo.PremiumAccount;
import spotifyGrupo4.db.pojo.Song;
import spotifyGrupo4.db.managers.FreeAccountManager;
import spotifyGrupo4.db.managers.PremiumAccountManager;

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
	private Band selectedBand = null;
	private Record selectedRecord = null;
	private Song selectedSong = null;
	private Podcaster selectedPodcaster = null;
	private Serie selectedSerie = null;
	private Content selectedContent = null;

	private AccountManager accountManager = null;
	private FreeAccountManager freeAccountManager = null;
	private PremiumAccountManager premiumAccountManager = null;

	private Session() {
		accountManager = new AccountManager();
		freeAccountManager = new FreeAccountManager();
		premiumAccountManager = new PremiumAccountManager();
	}

	public void updatePassword(Account account, JTextField password1) throws SQLException, Exception {
		if (null != account) {
			if (account.getAccountType().equalsIgnoreCase("Free")) {
				accountManager.updatePassword(accountManager.getByLogin(account.getDni()), password1.getText());
			} else if (account.getAccountType().equalsIgnoreCase("Premium")) {
				accountManager.updatePassword(accountManager.getByLogin(account.getDni()), password1.getText());
			} else if (account.getAccountType().equalsIgnoreCase("admin")) {
				accountManager.updatePassword(accountManager.getByLogin(account.getDni()), password1.getText());
			}
		}
	}

	public void insertNewFreeAccount(FreeAccount freeAccount) throws SQLException, Exception {
		freeAccountManager.insert(freeAccount);
	}

	public void insertNewPremiumAccount(PremiumAccount premiumAccount) throws SQLException, Exception {
		premiumAccountManager.insert(premiumAccount);
	}

	public boolean isLoginValid(JTextField dni) throws SQLException, Exception {

		if (accountManager.getByLogin(dni.getText()) != null) {
			return true;
		} else
			return false;
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

	public void clearTextFields(JTextField textFieldDni, JTextField textFieldNombre, JTextField textFieldMiddleName,
			JTextField textFieldSurname, JDateChooser dateChooser, JTextField textFieldPostalCode,
			JTextField textFieldCity, JTextField textFieldCountry, JTextField textFieldPassword,
			JTextField textFieldPassword2, JCheckBox chckbxFree, JCheckBox chckbxPremium,
			JTextField textFieldCreditCard, JDateChooser dateChooserCreditCard, JTextField textFieldCVV) {

		textFieldDni.setText("");
		textFieldNombre.setText("");
		textFieldMiddleName.setText("");
		textFieldSurname.setText("");
		dateChooser.setDate(null);
		textFieldPostalCode.setText("");
		textFieldCity.setText("");
		textFieldCountry.setText("");
		textFieldPassword.setText("");
		textFieldPassword2.setText("");
		chckbxFree.setSelected(false);
		chckbxPremium.setSelected(false);
		textFieldCreditCard.setText("");
		dateChooserCreditCard.setDate(null);
		textFieldCVV.setText("");
		chckbxFree.setSelected(true);
		chckbxPremium.setSelected(false);

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
	public boolean validateLogin(String dni, String password) throws SQLException, Exception {

		Account account = accountManager.getUser(dni, password);

		if (account != null) {
			setAccount(account);

			accountManager.updateLastLogin(account, new Date());

			return true;
		} else
			return false;
	}

	public FreeAccount createFreeAccount(JTextField textFieldDni, JTextField textFieldNombre,
			JTextField textFieldMiddleName, JTextField textFieldSurname, JDateChooser dateChooser,
			JTextField textFieldPostalCode, JTextField textFieldCity, JTextField textFieldCountry,
			JTextField textFieldPassword, JCheckBox chckbxFree) {

		FreeAccount ret = new FreeAccount();

		ret.setDni(textFieldDni.getText().trim());
		ret.setName(textFieldNombre.getText());
		ret.setMiddleName(textFieldMiddleName.getText().trim());
		ret.setSurName(textFieldSurname.getText().trim());
		ret.setBirthDate(dateChooser.getDate());
		ret.setRegistryDate(new Date());
		ret.setPostalCode(Integer.parseInt(textFieldPostalCode.getText().trim()));
		ret.setCity(textFieldCity.getText().trim());
		ret.setCountry(textFieldCountry.getText().trim());
		ret.setPassword(textFieldPassword.getText().trim());
		ret.setAccountType(chckbxFree.isSelected() == true ? "free" : "premium");

		setAccount(ret);
		return ret;
	}

	public PremiumAccount createPremiumAccount(JCheckBox chckbxPremium, JTextField textFieldCreditCard,
			JDateChooser dateChooserCreditCard, JTextField textFieldCVV) {

		PremiumAccount ret = new PremiumAccount();

		ret.setAccountType(chckbxPremium.isSelected() == true ? "premium" : "free");
		ret.setCardNumber(Long.parseLong(textFieldCreditCard.getText().trim()));
		ret.setCardCvv(Integer.parseInt(textFieldCVV.getText().trim()));
		ret.setExpiringDate(dateChooserCreditCard.getDate());

		return ret;
	}

	private boolean postalCodeVerify(JTextField PostalCode) {

		String postalCode = PostalCode.getText().trim();

		List<String> postalCodeList = new ArrayList<>();
		postalCodeList.add("12345");
		postalCodeList.add("67890");
		postalCodeList.add("98765");

		return postalCodeList.contains(postalCode);
	}

	private boolean cityVerify(JTextField City) {

		String city = City.getText().trim();

		List<String> cityList = new ArrayList<>();
		cityList.add("bilbao");
		cityList.add("madrid");
		cityList.add("barcelona");

		return cityList.contains(city);
	}

	private boolean countryVerify(JTextField Country) {

		String country = Country.getText().trim();

		List<String> countryList = new ArrayList<>();
		countryList.add("spain");

		return countryList.contains(country);

	}

	public boolean verifyRegister(JTextField PostalCode, JTextField City, JTextField Password, JTextField Password2,
			JTextField Country) {
		if (postalCodeVerify(PostalCode) && cityVerify(City) && isPasswordValid(Password, Password2)
				&& countryVerify(Country)) {
			return true;
		} else {
			return false;
		}
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

	public void resetAccount() {
		this.account = null;
	}

	public Band getSelectedBand() {
		return selectedBand;
	}

	public void setSelectedBand(Band selectedBand) {
		this.selectedBand = selectedBand;
	}

	public Record getSelectedRecord() {
		return selectedRecord;
	}

	public void setSelectedRecord(Record selectedRecord) {
		this.selectedRecord = selectedRecord;
	}

	public Serie getSelectedSerie() {
		return selectedSerie;
	}

	public void setSelectedSerie(Serie selectedSerie) {
		this.selectedSerie = selectedSerie;
	}

	public Song getSelectedSong() {
		return selectedSong;
	}

	public void setSelectedSong(Song selectedSong) {
		this.selectedSong = selectedSong;
	}

	public Podcaster getSelectedPodcaster() {
		return selectedPodcaster;
	}

	public void setSelectedPodcaster(Podcaster selectedPodcaster) {
		this.selectedPodcaster = selectedPodcaster;
	}

	public Content getSelectedContent() {
		return selectedContent;
	}

	public void setSelectedContent(Content selectedContent) {
		this.selectedContent = selectedContent;
	}

}
