package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import spotifyGrupo4.db.managers.FreeAccountManager;
import spotifyGrupo4.db.pojo.FreeAccount;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class RegisterPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8940817528876999995L;
	private JTextField textFieldNombre;
	private JTextField textFieldSurname;
	private JTextField textFieldMiddleName;
	private JTextField textFieldDni;
	private JTextField textFieldPassword;

	public RegisterPanel(List<JPanel> panels) {

		setBackground(new Color(159, 203, 217));
		setBounds(100, 100, 1278, 719);
		setLayout(null);

		JPanel panelFormulario = new JPanel();
		panelFormulario.setLayout(null);
		panelFormulario.setBounds(440, 105, 426, 522);
		add(panelFormulario);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 426, 522);
		panelFormulario.add(scrollPane);

		JPanel subpanel = new JPanel();
		subpanel.setPreferredSize(new Dimension(200, 1150));
		scrollPane.setViewportView(subpanel);
		subpanel.setLayout(null);

		JLabel lblUsuario = new JLabel("Nombre:");
		lblUsuario.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblUsuario.setBounds(39, 82, 76, 20);
		subpanel.add(lblUsuario);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(39, 112, 331, 40);
		subpanel.add(textFieldNombre);

		JLabel lblTitulo = new JLabel("R E G I S T R A R S E");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
		lblTitulo.setBounds(64, 23, 267, 57);
		subpanel.add(lblTitulo);

		JLabel lblApellido1 = new JLabel("Apellido 1:");
		lblApellido1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblApellido1.setBounds(39, 171, 97, 20);
		subpanel.add(lblApellido1);

		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(39, 202, 331, 40);
		subpanel.add(textFieldSurname);

		JLabel lblApellido2 = new JLabel("Apellido 2:");
		lblApellido2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblApellido2.setBounds(39, 253, 97, 20);
		subpanel.add(lblApellido2);

		textFieldMiddleName = new JTextField();
		textFieldMiddleName.setColumns(10);
		textFieldMiddleName.setBounds(39, 284, 331, 40);
		subpanel.add(textFieldMiddleName);

		JLabel lblDni = new JLabel("DNI:\r\n");
		lblDni.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblDni.setBounds(39, 335, 115, 20);
		subpanel.add(lblDni);

		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(39, 363, 331, 40);
		subpanel.add(textFieldDni);

		JCheckBox chckbxFree = new JCheckBox("Free\r\n");

		chckbxFree.setSelected(true);
		chckbxFree.setBounds(39, 1050, 97, 23);
		subpanel.add(chckbxFree);

		JCheckBox chckbxPremium = new JCheckBox("Premium\r\n");
		chckbxPremium.setBounds(141, 1050, 97, 23);
		subpanel.add(chckbxPremium);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblContraseña.setBounds(39, 414, 179, 20);
		subpanel.add(lblContraseña);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(39, 442, 331, 40);
		subpanel.add(textFieldPassword);

		JLabel lblfechaNacimiento = new JLabel("Fecha de nacimiento:\r\n");
		lblfechaNacimiento.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblfechaNacimiento.setBounds(39, 493, 179, 20);
		subpanel.add(lblfechaNacimiento);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setSize(331, 40);
		dateChooser.setLocation(39, 521);
		subpanel.add(dateChooser);

		JLabel lblCity = new JLabel("Ciudad:");
		lblCity.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCity.setBounds(39, 570, 179, 20);
		subpanel.add(lblCity);

		JTextField textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(39, 600, 331, 40);
		subpanel.add(textFieldCity);

		JLabel lblCounty = new JLabel("Pais:");
		lblCounty.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCounty.setBounds(39, 647, 179, 20);
		subpanel.add(lblCounty);

		JTextField textFieldCountry = new JTextField();
		textFieldCountry.setColumns(10);
		textFieldCountry.setBounds(39, 679, 331, 40);
		subpanel.add(textFieldCountry);

		JLabel lblPostCode = new JLabel("Codigo Postal:");
		lblPostCode.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblPostCode.setBounds(39, 724, 179, 20);
		subpanel.add(lblPostCode);

		JTextField textFieldPostalCode = new JTextField();
		textFieldPostalCode.setColumns(10);
		textFieldPostalCode.setBounds(39, 758, 331, 40);
		subpanel.add(textFieldPostalCode);

		JLabel lblCreditCard = new JLabel("Tarjeta de credito:");
		lblCreditCard.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCreditCard.setBounds(39, 801, 179, 20);
		subpanel.add(lblCreditCard);

		JTextField textFieldCreditCard = new JTextField();
		textFieldCreditCard.setColumns(10);
		textFieldCreditCard.setBounds(39, 837, 331, 40);
		subpanel.add(textFieldCreditCard);

		JLabel lblCreditCardexpiration = new JLabel("Caducidad:");
		lblCreditCardexpiration.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCreditCardexpiration.setBounds(39, 878, 179, 20);
		subpanel.add(lblCreditCardexpiration);

		JTextField textFieldCreditCardexpiration = new JTextField();
		textFieldCreditCardexpiration.setColumns(10);
		textFieldCreditCardexpiration.setBounds(39, 915, 331, 40);
		subpanel.add(textFieldCreditCardexpiration);

		JLabel lblCreditCVV = new JLabel("CVV:");
		lblCreditCVV.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCreditCVV.setBounds(39, 955, 179, 20);
		subpanel.add(lblCreditCVV);

		JTextField textFieldCVV = new JTextField();
		textFieldCVV.setColumns(10);
		textFieldCVV.setBounds(39, 992, 331, 40);
		subpanel.add(textFieldCVV);

		JPanel panelFormularioFondo = new JPanel();
		panelFormularioFondo.setLayout(null);
		panelFormularioFondo.setBackground(Color.BLACK);
		panelFormularioFondo.setBounds(469, 74, 436, 529);
		add(panelFormularioFondo);

		JButton btnRegistrarse = new JButton("ENTRAR");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (postalCodeVerify()) {

					FreeAccountManager freeAccountManager = new FreeAccountManager();
					FreeAccount newUser = new FreeAccount();
					Date date = new Date();

					newUser.setDni(textFieldDni.getText().trim());
					newUser.setName(textFieldNombre.getText());
					newUser.setMiddleName(textFieldMiddleName.getText().trim());
					newUser.setSurName(textFieldSurname.getText().trim());
					newUser.setBirthDate(dateChooser.getDate());
					newUser.setRegistryDate(date);
					newUser.setPostalCode(Integer.parseInt(textFieldPostalCode.getText().trim()));
					newUser.setCity(textFieldCity.getText().trim());
					newUser.setCountry(textFieldCountry.getText().trim());
					newUser.setPassword(textFieldPassword.getText().trim());
					newUser.setAccountType(chckbxFree.isSelected() == true ? "free" : "premium");

					try {
						freeAccountManager.insertUser(newUser);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Usuario registrado con exito");

					panels.get(0).setVisible(false);
					panels.get(1).setVisible(false);
					panels.get(2).setVisible(true);
					panels.get(3).setVisible(false);
					panels.get(4).setVisible(false);
					panels.get(5).setVisible(false);
					panels.get(6).setVisible(false);
					panels.get(7).setVisible(false);
					panels.get(8).setVisible(true);
					panels.get(9).setVisible(true);
					panels.get(10).setVisible(false);
					panels.get(11).setVisible(false);
					panels.get(12).setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "Error, Algun campo esta vacio o es incorrecto");
				}

			}

			private boolean postalCodeVerify() {

				String postalCode = textFieldPostalCode.getText().trim();

				List<String> postalCodeList = new ArrayList<>();
				postalCodeList.add("12345");
				postalCodeList.add("67890");
				postalCodeList.add("98765");

				return postalCodeList.contains(postalCode);
			}

		});
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnRegistrarse.setBackground(new Color(255, 51, 51));
		btnRegistrarse.setBounds(39, 1090, 331, 40);
		subpanel.add(btnRegistrarse);

		JButton btnClose = new JButton("CERRAR");
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
				panels.get(7).setVisible(true);
				panels.get(8).setVisible(false);
				panels.get(9).setVisible(false);
				panels.get(10).setVisible(false);
				panels.get(11).setVisible(false);
				panels.get(12).setVisible(false);
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(new Color(204, 51, 51));
		btnClose.setBounds(1129, 619, 89, 44);
		add(btnClose);

		chckbxFree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxPremium.setSelected(false);
				chckbxFree.setSelected(true);
				textFieldCreditCard.setEnabled(false);
				lblCreditCard.setEnabled(false);
				lblCreditCardexpiration.setEnabled(false);
				textFieldCreditCardexpiration.setEnabled(false);
				lblCreditCVV.setEnabled(false);
				textFieldCVV.setEnabled(false);
			}
		});

		chckbxPremium.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (chckbxPremium.isSelected()) {
					chckbxFree.setSelected(false);
					textFieldCreditCard.setEnabled(true);
					lblCreditCard.setEnabled(true);
					lblCreditCardexpiration.setEnabled(true);
					textFieldCreditCardexpiration.setEnabled(true);
					lblCreditCVV.setEnabled(true);
					textFieldCVV.setEnabled(true);

				} else {
					textFieldCreditCard.setEnabled(false);
					lblCreditCard.setEnabled(false);
					lblCreditCardexpiration.setEnabled(false);
					textFieldCreditCardexpiration.setEnabled(false);
					lblCreditCVV.setEnabled(false);
					textFieldCVV.setEnabled(false);
				}
			}

		});
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				textFieldCreditCard.setEnabled(false);
				lblCreditCard.setEnabled(false);
				lblCreditCardexpiration.setEnabled(false);
				textFieldCreditCardexpiration.setEnabled(false);
				lblCreditCVV.setEnabled(false);
				textFieldCVV.setEnabled(false);

			}
		});

	}
}
