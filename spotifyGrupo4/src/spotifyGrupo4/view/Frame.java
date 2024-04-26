package spotifyGrupo4.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import spotifyGrupo4.view.panels.AudioControlPanel;
import spotifyGrupo4.view.panels.BandPanel;
import spotifyGrupo4.view.panels.MenuPanel;
import spotifyGrupo4.view.panels.PodcasterPanel;

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

		MenuPanel menuPanel = new MenuPanel(panels);
		contentPanel.add(menuPanel);

		AudioControlPanel audioControlPanel = new AudioControlPanel();
		contentPanel.add(audioControlPanel);

		BandPanel bandPanel = new BandPanel();
		bandPanel.setVisible(false);
		contentPanel.add(bandPanel);
		panels.add(bandPanel);

		PodcasterPanel podcasterPanel = new PodcasterPanel();
		podcasterPanel.setVisible(false);
		contentPanel.add(podcasterPanel);
		panels.add(podcasterPanel);
	}
}
