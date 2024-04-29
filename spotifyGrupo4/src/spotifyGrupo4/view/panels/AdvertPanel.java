package spotifyGrupo4.view.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdvertPanel extends JPanel {

	private static final long serialVersionUID = -8354352845486534109L;

	public AdvertPanel() {

		setBounds(309, 0, 953, 618);
		setLayout(null);

		JLabel lblAdvertisementImage = new JLabel("IMAGEN DE DISCO");
		lblAdvertisementImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdvertisementImage.setBounds(187, 11, 578, 264);
		add(lblAdvertisementImage);

		JLabel lblDiscTitle = new JLabel("TITULO DE DISCO");
		lblDiscTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscTitle.setBounds(187, 296, 578, 34);
		add(lblDiscTitle);

		JLabel lblPublicationDate = new JLabel("FECHA PUBLICACION");
		lblPublicationDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublicationDate.setBounds(658, 425, 253, 34);
		add(lblPublicationDate);

		JLabel lblBandName = new JLabel("NOMBRE GRUPO");
		lblBandName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandName.setBounds(27, 425, 253, 34);
		add(lblBandName);

		JLabel lblGenre = new JLabel("GENERO");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setBounds(350, 425, 253, 34);
		add(lblGenre);
	}
}
