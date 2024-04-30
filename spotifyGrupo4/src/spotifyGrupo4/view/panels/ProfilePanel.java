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

public class ProfilePanel extends JPanel {
	private static final long serialVersionUID = -3095344526722788814L;
	private ProfileController profileController;
	private JTable tableCommonInfo;
	private JTable tableLoginInfo;
	private JTable tablePremiumAccountInfo;

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

		JLabel lblDatosDeRegistro = new JLabel("DATOS DE REGISTRO:");
		lblDatosDeRegistro.setForeground(Color.WHITE);
		lblDatosDeRegistro.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblDatosDeRegistro.setBounds(31, 345, 434, 24);
		add(lblDatosDeRegistro);

		tablePremiumAccountInfo = new JTable();
		tablePremiumAccountInfo.setModel(new DefaultTableModel(
				new Object[][] { { "Numero de Cuenta:", null }, { "Fecha de Caducidad", null }, { "CVV", null }, },
				new String[] { "Premium", "Info" }));
		tablePremiumAccountInfo.setBounds(31, 499, 434, 48);
		add(tablePremiumAccountInfo);

		JLabel lblDatosDeCuentaPremium = new JLabel("DATOS DE CUENTA PREMIUM:");
		lblDatosDeCuentaPremium.setForeground(Color.WHITE);
		lblDatosDeCuentaPremium.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblDatosDeCuentaPremium.setBounds(31, 464, 434, 24);
		add(lblDatosDeCuentaPremium);

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				handleFillInfoExceptions();
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

	private void handleFillInfoExceptions() {
		try {
			fillCommonInfoTable(profileController.getbyLogin(""), tableCommonInfo);
			fillLoginInfoTable(profileController.getbyLogin(""), tableLoginInfo);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}
}
