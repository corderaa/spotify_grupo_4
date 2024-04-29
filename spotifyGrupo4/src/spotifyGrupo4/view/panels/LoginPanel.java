package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = -5444702140440966162L;
	private JTextField textFieldMail = null;
	private JTextField textFieldPassword = null;
	private JPanel panelForm = null;
	private JLabel lblTitle = null;
	private JLabel lblMain = null;
	private JLabel lblPassword = null;
	private JButton btnLogin = null;
	private JButton btnClose = null;
	private JButton btnRegister = null;
	private JPanel panelFormBackground = null;

	public LoginPanel(List<JPanel> panels) {

		setBackground(new Color(159, 203, 217));
		setBounds(100, 100, 1278, 719);
		setLayout(null);

		panelForm = new JPanel();
		panelForm.setBounds(430, 122, 426, 468);
		panelForm.setLayout(null);
		add(panelForm);

		lblTitle = new JLabel("I N I C I A R  S E S I O N");
		lblTitle.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(53, 41, 320, 57);
		panelForm.add(lblTitle);

		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(42, 140, 331, 40);
		panelForm.add(textFieldMail);

		lblMain = new JLabel("Correo:");
		lblMain.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblMain.setBounds(42, 109, 76, 20);
		panelForm.add(lblMain);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(42, 239, 331, 40);
		panelForm.add(textFieldPassword);

		lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblPassword.setBounds(42, 208, 115, 20);
		panelForm.add(lblPassword);

		btnRegister = new JButton("REGISTRATE SI NO TIENES CUENTA");
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(255, 51, 51));
		btnRegister.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnRegister.setBounds(42, 377, 331, 57);
		panelForm.add(btnRegister);

		btnLogin = new JButton("ENTRAR");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(255, 51, 51));
		btnLogin.setBounds(42, 309, 331, 57);
		panelForm.add(btnLogin);

		panelFormBackground = new JPanel();
		panelFormBackground.setLayout(null);
		panelFormBackground.setBackground(Color.BLACK);
		panelFormBackground.setBounds(459, 91, 436, 468);
		add(panelFormBackground);

		btnClose = new JButton("CERRAR");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(204, 51, 51));
		btnClose.setBounds(1159, 620, 89, 44);
		add(btnClose);

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	/**
	 * Clears the text fields
	 * 
	 * @param textFieldMail
	 * @param textFieldPassword
	 */
	private void clearTextFields(JTextField textFieldMail, JTextField textFieldPassword) {
		textFieldMail.setText(null);
		textFieldPassword.setText(null);
	}
}
