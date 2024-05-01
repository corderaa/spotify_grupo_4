package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */

	public WelcomePanel(List<JPanel> panels) {
		

		setBackground(new Color(159, 203, 217));
		setBounds(100, 100, 1278, 719);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("BIENVENIDO A SPOTIFY RETO4");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 40));
		lblTitulo.setBounds(277, 294, 723, 130);
		add(lblTitulo);
		
		JLabel lblTitulo_fondo = new JLabel("BIENVENIDO A SPOTIFY RETO4");
		lblTitulo_fondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo_fondo.setForeground(Color.BLACK);
		lblTitulo_fondo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 40));
		lblTitulo_fondo.setBounds(272, 294, 723, 130);
		add(lblTitulo_fondo);
		
		JLabel lblNewLabel = new JLabel("PULSA DONDE QUIERAS PARA CONTINUAR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(401, 395, 476, 51);
		add(lblNewLabel);
		
		JLabel lblNewLabel_fondo = new JLabel("PULSA DONDE QUIERAS PARA CONTINUAR");
		lblNewLabel_fondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_fondo.setForeground(Color.BLACK);
		lblNewLabel_fondo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_fondo.setBounds(401, 395, 473, 51);
		add(lblNewLabel_fondo);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				
			}
		});
		
	} 
}
