package spotifyGrupo4.view.panels;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PodcastPanel extends JPanel {

	private static final long serialVersionUID = -3076849397835644353L;

	public PodcastPanel(List<JPanel> panels) {
		setBounds(309, 0, 953, 618);
		setLayout(null);

		JLabel lblPodcastTitle = new JLabel(" PODCAST TITLE");
		lblPodcastTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcastTitle.setBounds(82, 204, 576, 163);
		add(lblPodcastTitle);

		JLabel lblReproductionNumber = new JLabel("REPRODUCTION NUMBER");
		lblReproductionNumber.setBounds(692, 204, 180, 163);
		add(lblReproductionNumber);

		JLabel lblDuration = new JLabel("DURATION");
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setBounds(82, 429, 576, 149);
		add(lblDuration);
	}
}
