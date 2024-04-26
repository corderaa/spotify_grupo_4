package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SongPanel extends JPanel {

	private static final long serialVersionUID = -1754009495368908597L;

	public SongPanel(List<JPanel> panels) {
		setBounds(309, 0, 953, 618);
		setLayout(null);

		JLabel lblSongTitle = new JLabel(" SONG TITLE");
		lblSongTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSongTitle.setBounds(82, 204, 576, 163);
		add(lblSongTitle);

		JLabel lblReproductionNumber = new JLabel("REPRODUCTION NUMBER");
		lblReproductionNumber.setBounds(692, 204, 180, 163);
		add(lblReproductionNumber);

		JLabel lblDuration = new JLabel("DURATION");
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setBounds(82, 429, 576, 149);
		add(lblDuration);

	}

}
