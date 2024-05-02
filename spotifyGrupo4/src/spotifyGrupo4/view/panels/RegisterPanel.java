package spotifyGrupo4.view.panels;

import java.awt.Color;

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

public class RegisterPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8940817528876999995L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public RegisterPanel(List<JPanel> panels) {
		setBackground(new Color(159, 203, 217));
		setBounds(100, 100, 1278, 719);
		setLayout(null);
		
		JPanel panelFormulario = new JPanel();
		panelFormulario.setLayout(null);
		panelFormulario.setBounds(440, 105, 426, 522);
		add(panelFormulario);
		
		JLabel lblTitulo = new JLabel("R E G I S T R A R S E");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
		lblTitulo.setBounds(79, 30, 267, 57);
		panelFormulario.add(lblTitulo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(47, 119, 131, 40);
		panelFormulario.add(textField);
		
		JLabel lblUsuario = new JLabel("Nombre:");
		lblUsuario.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblUsuario.setBounds(47, 89, 76, 20);
		panelFormulario.add(lblUsuario);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(47, 291, 331, 40);
		panelFormulario.add(textField_1);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCorreo.setBounds(47, 260, 76, 20);
		panelFormulario.add(lblCorreo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(47, 370, 331, 40);
		panelFormulario.add(textField_2);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblContrasea.setBounds(47, 342, 115, 20);
		panelFormulario.add(lblContrasea);
		
		JButton btnRegistrarse = new JButton("ENTRAR");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnRegistrarse.setBackground(new Color(255, 51, 51));
		btnRegistrarse.setBounds(47, 459, 331, 40);
		panelFormulario.add(btnRegistrarse);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblDni.setBounds(47, 178, 76, 20);
		panelFormulario.add(lblDni);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(47, 209, 331, 40);
		panelFormulario.add(textField_3);
		
		JCheckBox chckbxMale = new JCheckBox("Hombre");
		chckbxMale.setSelected(true);
		chckbxMale.setBounds(47, 424, 97, 23);
		panelFormulario.add(chckbxMale);
		
		JCheckBox chckbxFemale = new JCheckBox("Mujer");
		chckbxFemale.setBounds(146, 424, 97, 23);
		panelFormulario.add(chckbxFemale);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(247, 119, 131, 40);
		panelFormulario.add(textField_4);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblApellidos.setBounds(247, 89, 76, 20);
		panelFormulario.add(lblApellidos);
		
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
