package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.controllers.ProfileController;
import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.PremiumAccount;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilePanel extends JPanel {
	private static final long serialVersionUID = -3095344526722788814L;
	private ProfileController profileController;
	private JTable tableCommonInfo;
	private JTable tableLoginInfo;
	private JTable tablePremiumAccountInfo;
	private JTextField textFieldPassword1;
	private JTextField textFieldPassword2;

	public ProfilePanel() {

		profileController = new ProfileController();

		setBounds(309, 0, 953, 618);
		setBackground(new Color(40, 40, 40));
		setLayout(null);

		JLabel lblName = new JLabel("BIENVENIDO USER");
		lblName.setForeground(new Color(204, 0, 51));
		lblName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 33));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(31, 11, 670, 58);
		add(lblName);

		JLabel lblWelcomeUser = new JLabel("BIENVENIDO USER");
		lblWelcomeUser.setForeground(new Color(255, 255, 255));
		lblWelcomeUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeUser.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 33));
		lblWelcomeUser.setBounds(33, 13, 670, 58);
		add(lblWelcomeUser);

		JPanel line = new JPanel();
		line.setBackground(new Color(204, 0, 51));
		line.setBounds(31, 69, 434, 4);
		add(line);

		JPanel line_Background = new JPanel();
		line_Background.setBackground(new Color(255, 255, 255));
		line_Background.setBounds(38, 71, 430, 4);
		add(line_Background);

		tableCommonInfo = new JTable();
		tableCommonInfo.setBounds(31, 157, 434, 144);
		add(tableCommonInfo);

		JLabel lblTitleTable1 = new JLabel("DATOS COMUNES:");
		lblTitleTable1.setForeground(new Color(255, 255, 255));
		lblTitleTable1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblTitleTable1.setBounds(31, 122, 434, 24);
		add(lblTitleTable1);

		tableLoginInfo = new JTable();
		tableLoginInfo.setBounds(31, 380, 434, 48);
		add(tableLoginInfo);

		JLabel lblRegistryInfo = new JLabel("DATOS DE REGISTRO:");
		lblRegistryInfo.setForeground(Color.WHITE);
		lblRegistryInfo.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblRegistryInfo.setBounds(31, 345, 434, 24);
		add(lblRegistryInfo);

		tablePremiumAccountInfo = new JTable();
		tablePremiumAccountInfo.setBounds(31, 499, 434, 48);
		add(tablePremiumAccountInfo);

		JLabel lblPremiumAccountInfo = new JLabel("DATOS DE CUENTA PREMIUM:");
		lblPremiumAccountInfo.setForeground(Color.WHITE);
		lblPremiumAccountInfo.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblPremiumAccountInfo.setBounds(31, 464, 434, 24);
		add(lblPremiumAccountInfo);

		JLabel lblPasswordChange = new JLabel("PARSSWORD CHANGE:");
		lblPasswordChange.setForeground(Color.WHITE);
		lblPasswordChange.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblPasswordChange.setBounds(475, 122, 434, 24);
		add(lblPasswordChange);

		textFieldPassword1 = new JTextField();
		textFieldPassword1.setBounds(475, 182, 434, 20);
		add(textFieldPassword1);
		textFieldPassword1.setColumns(10);

		textFieldPassword2 = new JTextField();
		textFieldPassword2.setColumns(10);
		textFieldPassword2.setBounds(475, 237, 434, 20);
		add(textFieldPassword2);

		JLabel lblFirstPassword = new JLabel("FIRST PASSWORD:");
		lblFirstPassword.setForeground(Color.WHITE);
		lblFirstPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblFirstPassword.setBounds(475, 157, 434, 24);
		add(lblFirstPassword);

		JLabel lblSecondPassword = new JLabel("SECOND PASSWORD:");
		lblSecondPassword.setForeground(Color.WHITE);
		lblSecondPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblSecondPassword.setBounds(475, 213, 434, 24);
		add(lblSecondPassword);

		JButton btnNewButton = new JButton("DONE");

		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(475, 268, 434, 33);
		add(btnNewButton);

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				handleFillInfoExceptions();
			}
		});

		/**
		 * PasswordChange
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void fillCommonInfoTable(Account account, JTable tableCommonInfo) {

		tableCommonInfo.setModel(new DefaultTableModel(
				new Object[][] { { "Nombre:", account.getName() }, { "Apellido:", account.getMiddleName() },
						{ "Apellido2:",
								new String(account.getSurName() == null ? "no hay datos" : account.getSurName()) },
						{ "DNI:", account.getDni() }, { "Fecha De Nacimiento:", account.getBirthDate() },
						{ "Codigo Postal:", account.getPostalCode() }, { "Ciudad:", account.getCity() },
						{ "Provincia", account.getCountry() }, },
				new String[] { "datos", "comunes" }));
	}

	private void fillLoginInfoTable(Account account, JTable tableLoginInfo) {

		tableLoginInfo
				.setModel(
						new DefaultTableModel(
								new Object[][] { { "Login:", account.getDni() }, { "Password:", account.getPassword() },
										{ "Tipo Cliente:", account.getAccountType() }, },
								new String[] { "DATOS", "CUENTA" }));
	}

	private void fillPremiumInfoTable(PremiumAccount premiumAccount, JTable tablePremiumAccountInfo) {

		tablePremiumAccountInfo.setModel(new DefaultTableModel(
				new Object[][] { { "Numero de Cuenta:", null }, { "Fecha de Caducidad", null }, { "CVV", null }, },
				new String[] { "Premium", "Info" }));

	}

	private void handleFillInfoExceptions() {
		try {
			fillCommonInfoTable(profileController.getbyLogin(""), tableCommonInfo);
			fillLoginInfoTable(profileController.getbyLogin(""), tableLoginInfo);
			fillPremiumInfoTable(profileController.getPremiumByLogin(""), tablePremiumAccountInfo); // CAMBIAR POR
																									// SEPARADO
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
