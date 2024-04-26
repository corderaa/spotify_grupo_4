package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AudioControlPanel extends JPanel {

	private static final long serialVersionUID = -8918841376411061446L;

	private final String PLAY_ICON_URL = ".//img//play-solid.png";
	private final String STOP_ICON_URL = ".//img//pause-solid.png";
	private final String NEXT_ICON_URL = ".//img//forward-solid.png";
	private final String PREVIUS_ICON_URL = ".//img//backward-solid.png";
	private final String LIKE_ICON_URL = ".//img//heart-solid.png";

	public AudioControlPanel() {
		setBackground(new Color(51, 51, 51));
		setBounds(309, 618, 953, 62);
		setLayout(null);

		JLabel lblStartStop = new JLabel(new ImageIcon(PLAY_ICON_URL));
		lblStartStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lblStartStop.setForeground(new Color(255, 255, 255));
		lblStartStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartStop.setBounds(453, 11, 76, 40);
		add(lblStartStop);

		JLabel lblPrevius = new JLabel(new ImageIcon(PREVIUS_ICON_URL));
		lblPrevius.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblPrevius.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrevius.setForeground(new Color(255, 255, 255));
		lblPrevius.setBounds(397, 11, 46, 40);
		add(lblPrevius);

		JLabel lblNext = new JLabel(new ImageIcon(NEXT_ICON_URL));
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(new Color(255, 255, 255));
		lblNext.setBounds(539, 11, 46, 40);
		add(lblNext);

		JLabel lblLike = new JLabel(new ImageIcon(LIKE_ICON_URL));
		lblLike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setForeground(new Color(255, 255, 255));
		lblLike.setBounds(885, 11, 46, 40);
		add(lblLike);
	}
}
