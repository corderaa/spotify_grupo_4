package spotifyGrupo4.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import spotifyGrupo4.db.pojo.Serie;
import spotifyGrupo4.view.panels.AdvertPanel;
import spotifyGrupo4.view.panels.AudioControlPanel;
import spotifyGrupo4.view.panels.BandPanel;
import spotifyGrupo4.view.panels.LoginPanel;
import spotifyGrupo4.view.panels.MenuPanel;
import spotifyGrupo4.view.panels.PodcastPanel;
import spotifyGrupo4.view.panels.PodcasterPanel;
import spotifyGrupo4.view.panels.ProfilePanel;
import spotifyGrupo4.view.panels.RecordPanel;
import spotifyGrupo4.view.panels.RegisterPanel;
import spotifyGrupo4.view.panels.SeriePanel;
import spotifyGrupo4.view.panels.SongPanel;
import spotifyGrupo4.view.panels.WelcomePanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.management.loading.PrivateClassLoader;
import javax.security.auth.login.LoginContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;

	private List<JPanel> panels = null;

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

		panels = new ArrayList<JPanel>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1278, 719);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(51, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		// 0
		BandPanel bandPanel = new BandPanel(panels);
		bandPanel.setVisible(false);
		contentPanel.add(bandPanel);
		panels.add(bandPanel);

		// 1
		PodcasterPanel podcasterPanel = new PodcasterPanel(panels);
		podcasterPanel.setVisible(false);
		contentPanel.add(podcasterPanel);
		panels.add(podcasterPanel);

		// 2
		AdvertPanel advertPanel = new AdvertPanel();
		advertPanel.setVisible(false);
		contentPanel.add(advertPanel);
		panels.add(advertPanel);

		// 3
		RecordPanel recordPanel = new RecordPanel(panels);
		recordPanel.setVisible(false);
		contentPanel.add(recordPanel);
		panels.add(recordPanel);

		// 4
		SeriePanel seriePanel = new SeriePanel(panels);
		seriePanel.setVisible(false);
		contentPanel.add(seriePanel);
		panels.add(seriePanel);

		// 5
		SongPanel songPanel = new SongPanel(panels);
		songPanel.setVisible(false);
		contentPanel.add(songPanel);
		panels.add(songPanel);

		// 6
		PodcastPanel podcastPanel = new PodcastPanel(panels);
		podcastPanel.setVisible(false);
		contentPanel.add(podcastPanel);
		panels.add(podcastPanel);

		// 7
		LoginPanel loginPanel = new LoginPanel(panels);
		loginPanel.setLocation(0, 0);
		loginPanel.setVisible(false);
		contentPanel.add(loginPanel);
		panels.add(loginPanel);

		// 8
		MenuPanel menuPanel = new MenuPanel(panels);
		contentPanel.add(menuPanel);
		menuPanel.setVisible(false);
		panels.add(menuPanel);

		// 9
		AudioControlPanel audioControlPanel = new AudioControlPanel();
		contentPanel.add(audioControlPanel);
		audioControlPanel.setVisible(false);
		panels.add(audioControlPanel);

		// 10
		ProfilePanel profilePanel = new ProfilePanel();
		contentPanel.add(profilePanel);
		profilePanel.setVisible(false);
		panels.add(profilePanel);
		
		// 11
		WelcomePanel welcomePanel = new WelcomePanel(panels);
		welcomePanel.setLocation(0, 0);
		welcomePanel.setVisible(true);
		contentPanel.add(welcomePanel);
		panels.add(welcomePanel);
		
		// 12
		RegisterPanel registerPanel = new RegisterPanel(panels);
		registerPanel.setLocation(0, 0);
		registerPanel.setVisible(false);
		contentPanel.add(registerPanel);
		panels.add(registerPanel);
		
		
		
		
	}
}
