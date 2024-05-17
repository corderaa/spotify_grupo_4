package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import spotifyGrupo4.controllers.AudioController;
import spotifyGrupo4.controllers.Session;
import spotifyGrupo4.view.ExceptionHandler;

public class AudioControlPanel extends JPanel {

	private static final long serialVersionUID = -8918841376411061446L;

	private final String PLAY_ICON_URL = ".//img//play-solid.png";
	private final String STOP_ICON_URL = ".//img//pause-solid.png";
	private final String NEXT_ICON_URL = ".//img//forward-solid.png";
	private final String PREVIUS_ICON_URL = ".//img//backward-solid.png";
	private final String LIKE_ICON_URL = ".//img//heart-solid.png";

	private JLabel lblStartStop = null;
	private JLabel lblPrevius = null;
	private JLabel lblNext = null;
	private JLabel lblLike = null;
	private boolean isPlaying = false;

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
				try {
					if (null != Session.getInstance().getSelectedContent()) {

						if (!isPlaying) {
							lblStartStop.setIcon(new ImageIcon(STOP_ICON_URL));
							AudioController.getInstance().playContent();
							isPlaying = true;

							AudioController.getInstance().addReproduction(Session.getInstance().getSelectedContent());

						} else {
							lblStartStop.setIcon(new ImageIcon(PLAY_ICON_URL));
							AudioController.getInstance().stopContent();
							isPlaying = false;
						}
					} else {
						JOptionPane.showMessageDialog(null, "No hay ningun contenido selecctionado");
					}
				} catch (SQLException sqle) {
					ExceptionHandler.handleSqlException(sqle, sqle.getMessage());
				} catch (Exception e1) {
					ExceptionHandler.handleGenericException(e1, "Ha habido un error: " + e1.getMessage());
				}
			}
		});

		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (null != Session.getInstance().getSelectedContent()) {

					try {
						AudioController.getInstance().changeNextContent();
					} catch (IndexOutOfBoundsException outOfBounds) {
						ExceptionHandler.handleIndexOutOfBoundsException(outOfBounds,
								"Ha ocurrido un error, no se ha podido cargar la siguiente cancion/podcast");
					} catch (Exception e2) {
						ExceptionHandler.handleGenericException(e2,
								"Ha ocurrido un error, no se ha podido cargar la siguiente cancion/podcast");
					}
				}

			}
		});

		lblPrevius.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (null != Session.getInstance().getSelectedContent()) {
					try {
						// AudioController.getInstance().changePreviusContent();
					} catch (IndexOutOfBoundsException outOfBounds) {
						ExceptionHandler.handleIndexOutOfBoundsException(outOfBounds,
								"Ha ocurrido un error, no se ha podido cargar la siguiente cancion/podcast");
					} catch (Exception e2) {
						ExceptionHandler.handleGenericException(e2,
								"Ha ocurrido un error, no se ha podido cargar la siguiente cancion/podcast");
					}

				}
			}
		});

		lblLike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}
