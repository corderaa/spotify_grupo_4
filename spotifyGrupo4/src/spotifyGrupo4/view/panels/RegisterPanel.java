package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class RegisterPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8940817528876999995L;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_5;

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
		
		JPanel Subpanel = new JPanel();
		Subpanel.setPreferredSize(new Dimension(200, 900));
		scrollPane.setViewportView(Subpanel);
		Subpanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Nombre:");
		lblUsuario.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblUsuario.setBounds(39, 82, 76, 20);
		Subpanel.add(lblUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(39, 112, 331, 40);
		Subpanel.add(textField);
		
		JLabel lblTitulo = new JLabel("R E G I S T R A R S E");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
		lblTitulo.setBounds(64, 23, 267, 57);
		Subpanel.add(lblTitulo);
		
		JLabel lblApellido1 = new JLabel("Apellido 1:");
		lblApellido1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblApellido1.setBounds(39, 171, 97, 20);
		Subpanel.add(lblApellido1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(39, 202, 331, 40);
		Subpanel.add(textField_2);
		
		JLabel lblApellido2 = new JLabel("Apellido 2:");
		lblApellido2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblApellido2.setBounds(39, 253, 97, 20);
		Subpanel.add(lblApellido2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(39, 284, 331, 40);
		Subpanel.add(textField_3);
		
		JLabel lblDni = new JLabel("DNI:\r\n");
		lblDni.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblDni.setBounds(39, 335, 115, 20);
		Subpanel.add(lblDni);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(39, 363, 331, 40);
		Subpanel.add(textField_4);
		
		JCheckBox chckbxFree = new JCheckBox("Free\r\n");
		chckbxFree.setSelected(true);
		chckbxFree.setBounds(39, 810, 97, 23);
		Subpanel.add(chckbxFree);
		
		JCheckBox chckbxPremium = new JCheckBox("Premium\r\n");
		chckbxPremium.setBounds(141, 810, 97, 23);
		Subpanel.add(chckbxPremium);
		
		JButton btnRegistrarse = new JButton("ENTRAR");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnRegistrarse.setBackground(new Color(255, 51, 51));
		btnRegistrarse.setBounds(39, 850, 331, 40);
		Subpanel.add(btnRegistrarse);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblContraseña.setBounds(39, 414, 179, 20);
		Subpanel.add(lblContraseña);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(39, 442, 331, 40);
		Subpanel.add(textField_1);
		
		JLabel lblfechaNacimiento = new JLabel("Fecha de nacimiento:\r\n");
		lblfechaNacimiento.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblfechaNacimiento.setBounds(39, 493, 179, 20);
		Subpanel.add(lblfechaNacimiento);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(39, 521, 331, 40);
		Subpanel.add(textField_5);
		
		JLabel lblCity = new JLabel("Ciudad:");
		lblCity.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCity.setBounds(39, 570, 179, 20);
		Subpanel.add(lblCity);
		
		JTextField textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(39, 600, 331, 40);
		Subpanel.add(textField_6);
		
		JLabel lblCounty = new JLabel("Pais:");
		lblCounty.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCounty.setBounds(39, 647, 179, 20);
		Subpanel.add(lblCounty);
		
		JTextField textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(39, 679, 331, 40);
		Subpanel.add(textField_7);
		
		JLabel lblPostCode = new JLabel("Codigo Postal:");
		lblPostCode.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblPostCode.setBounds(39, 724, 179, 20);
		Subpanel.add(lblPostCode);
		
		JTextField textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(39, 758, 331, 40);
		Subpanel.add(textField_8);
		
		JPanel panelFormularioFondo = new JPanel();
		panelFormularioFondo.setLayout(null);
		panelFormularioFondo.setBackground(Color.BLACK);
		panelFormularioFondo.setBounds(469, 74, 436, 529);
		add(panelFormularioFondo);
		
		
		
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
		
	}
}
