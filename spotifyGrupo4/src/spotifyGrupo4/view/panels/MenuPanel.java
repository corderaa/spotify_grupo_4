package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import spotifyGrupo4.controllers.Session;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = -5871082331159322418L;

	public MenuPanel(List<JPanel> panels) {
		setBackground(new Color(51, 51, 51));
		setBounds(0, 0, 310, 680);
		setLayout(null);

		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(104, 52, 102, 72);
		add(lblLogo);

		JButton btnAdmin = new JButton("Administration");
		btnAdmin.setBackground(new Color(255, 255, 255));
		btnAdmin.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnAdmin.setBounds(50, 150, 209, 40);
		add(btnAdmin);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Session.getInstance() == null
						|| Session.getInstance().getAccount().getAccountType().equals("admin") == false) {
				} else if (Session.getInstance().getAccount().getAccountType().equals("admin")) {
					panels.get(0).setVisible(false);
					panels.get(1).setVisible(false);
					panels.get(2).setVisible(false);
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
					panels.get(13).setVisible(false);
					panels.get(14).setVisible(true);
				}

			}
		});

		JButton btnGroups = new JButton("Descubre Grupos");
		btnGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(0).setVisible(true);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
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
				panels.get(13).setVisible(false);

				panels.get(14).setVisible(false);

			}
		});

		btnGroups.setBackground(new Color(255, 255, 255));
		btnGroups.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnGroups.setBounds(50, 210, 209, 54);
		add(btnGroups);

		JButton btnPodcasts = new JButton("Descubre Podcast");
		btnPodcasts.setBackground(new Color(255, 255, 255));
		btnPodcasts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(true);
				panels.get(2).setVisible(false);
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
				panels.get(13).setVisible(false);
				panels.get(14).setVisible(false);

			}
		});
		btnPodcasts.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnPodcasts.setBounds(50, 358, 209, 54);
		add(btnPodcasts);

		JButton btnFavorites = new JButton("Mis Favoritos");
		btnFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
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
				panels.get(13).setVisible(true);
				panels.get(14).setVisible(false);
			}
		});
		btnFavorites.setBackground(new Color(255, 255, 255));
		btnFavorites.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnFavorites.setBounds(50, 439, 209, 54);
		add(btnFavorites);

		JButton btnSignOut = new JButton("Salir");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
				panels.get(7).setVisible(false);
				panels.get(8).setVisible(false);
				panels.get(9).setVisible(false);
				panels.get(10).setVisible(false);
				panels.get(11).setVisible(true);
				panels.get(12).setVisible(false);
				panels.get(13).setVisible(false);
				panels.get(14).setVisible(false);
			}
		});
		btnSignOut.setBackground(new Color(255, 255, 255));
		btnSignOut.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnSignOut.setBounds(50, 517, 209, 54);
		add(btnSignOut);

		JButton btnProfile = new JButton("Perfil");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
				panels.get(7).setVisible(false);
				panels.get(8).setVisible(true);
				panels.get(9).setVisible(true);
				panels.get(10).setVisible(true);
				panels.get(11).setVisible(false);
				panels.get(12).setVisible(false);
				panels.get(13).setVisible(false);
				panels.get(14).setVisible(false);
			}
		});
		btnProfile.setBackground(new Color(255, 255, 255));
		btnProfile.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnProfile.setBounds(50, 596, 209, 54);
		add(btnProfile);
	}
}
