package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import spotifyGrupo4.controllers.AudioController;

public class AudioControlPanel extends JPanel {

	private static final long serialVersionUID = -8918841376411061446L;

	private final String PLAY_ICON_URL = ".//img//play-solid.png";
	private final String STOP_ICON_URL = ".//img//pause-solid.png";
	private final String NEXT_ICON_URL = ".//img//forward-solid.png";
	private final String PREVIUS_ICON_URL = ".//img//backward-solid.png";
	private final String LIKE_ICON_URL = ".//img//heart-solid.png";
	private int currentSongPlayed = 0;

	private JLabel lblStartStop = null;
	private JLabel lblPrevius = null;
	private JLabel lblNext = null;
	private JLabel lblLike = null;

	public AudioControlPanel() {
		setBackground(new Color(51, 51, 51));
		setBounds(309, 618, 953, 62);
		setLayout(null);

		lblStartStop = new JLabel(new ImageIcon(PLAY_ICON_URL));
		lblStartStop.setForeground(new Color(255, 255, 255));
		lblStartStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartStop.setBounds(453, 11, 76, 40);
		add(lblStartStop);

		lblPrevius = new JLabel(new ImageIcon(PREVIUS_ICON_URL));
		lblPrevius.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrevius.setForeground(new Color(255, 255, 255));
		lblPrevius.setBounds(397, 11, 46, 40);
		add(lblPrevius);

		lblNext = new JLabel(new ImageIcon(NEXT_ICON_URL));
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(new Color(255, 255, 255));
		lblNext.setBounds(539, 11, 46, 40);
		add(lblNext);

		lblLike = new JLabel(new ImageIcon(LIKE_ICON_URL));
		lblLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblLike.setForeground(new Color(255, 255, 255));
		lblLike.setBounds(885, 11, 46, 40);
		add(lblLike);

		lblStartStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblStartStop.getIcon().getIconHeight() == (new ImageIcon(PLAY_ICON_URL).getIconHeight())) {
					lblStartStop.setIcon(new ImageIcon(STOP_ICON_URL));
				} else {
					lblStartStop.setIcon(new ImageIcon(PLAY_ICON_URL));
				}
			}
		});

		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AudioController.getInstance().getContents().get(currentSongPlayed + 1);
				} catch (IndexOutOfBoundsException outOfBounds) {
					handleIndexOutOfBounds(outOfBounds);
				} catch (Exception e2) {
					handleGenericException(e2);
				}

			}
		});

		lblPrevius.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AudioController.getInstance().getContents().get(currentSongPlayed - 1);
				} catch (IndexOutOfBoundsException outOfBounds) {
					handleIndexOutOfBounds(outOfBounds);
				} catch (Exception e2) {
					handleGenericException(e2);
				}

			}
		});

		lblLike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void handleIndexOutOfBounds(IndexOutOfBoundsException outOfBounds) {
		JOptionPane.showMessageDialog(null, outOfBounds.getMessage());
	}

	private void handleGenericException(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
}
