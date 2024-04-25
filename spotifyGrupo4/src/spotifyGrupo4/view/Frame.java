package spotifyGrupo4.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private final String PLAY_ICON_URL = ".//img//play-solid.png";
	private final String STOP_ICON_URL = ".//img//pause-solid.png";
	private final String NEXT_ICON_URL = ".//img//forward-solid.png";
	private final String PREVIUS_ICON_URL = ".//img//backward-solid.png";
	private final String LIKE_ICON_URL = ".//img//heart-solid.png";

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			Frame frame = new Frame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1278, 719);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(51, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(51, 51, 51));
		menuPanel.setBounds(0, 0, 310, 680);
		contentPanel.add(menuPanel);
		menuPanel.setLayout(null);

		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(104, 52, 102, 72);
		menuPanel.add(lblLogo);

		JButton btnGroups = new JButton("Descubre Grupos");
		btnGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGroups.setBackground(new Color(255, 255, 255));
		btnGroups.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnGroups.setBounds(50, 280, 209, 54);
		menuPanel.add(btnGroups);

		JButton btnPodcasts = new JButton("Descubre Podcast");
		btnPodcasts.setBackground(new Color(255, 255, 255));
		btnPodcasts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPodcasts.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnPodcasts.setBounds(50, 358, 209, 54);
		menuPanel.add(btnPodcasts);

		JButton btnFavorites = new JButton("Mis Favoritos");
		btnFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFavorites.setBackground(new Color(255, 255, 255));
		btnFavorites.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnFavorites.setBounds(50, 439, 209, 54);
		menuPanel.add(btnFavorites);

		JButton btnSignOut = new JButton("Salir");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignOut.setBackground(new Color(255, 255, 255));
		btnSignOut.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnSignOut.setBounds(50, 517, 209, 54);
		menuPanel.add(btnSignOut);

		JButton btnProfile = new JButton("Perfil");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProfile.setBackground(new Color(255, 255, 255));
		btnProfile.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		btnProfile.setBounds(50, 596, 209, 54);
		menuPanel.add(btnProfile);

		JPanel audioControllPanel = new JPanel();
		audioControllPanel.setBackground(new Color(51, 51, 51));
		audioControllPanel.setBounds(309, 618, 953, 62);
		contentPanel.add(audioControllPanel);
		audioControllPanel.setLayout(null);

		JLabel lblStartStop = new JLabel(new ImageIcon(PLAY_ICON_URL));
		lblStartStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblStartStop.setForeground(new Color(255, 255, 255));
		lblStartStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartStop.setBounds(453, 11, 76, 40);
		audioControllPanel.add(lblStartStop);

		JLabel lblPrevius = new JLabel(new ImageIcon(PREVIUS_ICON_URL));
		lblPrevius.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblPrevius.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrevius.setForeground(new Color(255, 255, 255));
		lblPrevius.setBounds(397, 11, 46, 40);
		audioControllPanel.add(lblPrevius);

		JLabel lblNext = new JLabel(new ImageIcon(NEXT_ICON_URL));
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(new Color(255, 255, 255));
		lblNext.setBounds(539, 11, 46, 40);
		audioControllPanel.add(lblNext);

		JLabel lblLike = new JLabel(new ImageIcon(LIKE_ICON_URL));
		lblLike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setForeground(new Color(255, 255, 255));
		lblLike.setBounds(885, 11, 46, 40);
		audioControllPanel.add(lblLike);

		JPanel abstractPanel = new JPanel();
		abstractPanel.setBackground(new Color(153, 255, 153));
		abstractPanel.setBounds(309, 0, 953, 618);
		contentPanel.add(abstractPanel);
		abstractPanel.setLayout(null);
	}
}
