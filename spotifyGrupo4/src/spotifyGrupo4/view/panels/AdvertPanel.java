package spotifyGrupo4.view.panels;

import javax.swing.JPanel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import spotifyGrupo4.controllers.AdvertController;

public class AdvertPanel extends JPanel {

	private static final long serialVersionUID = -8354352845486534109L;

	public AdvertPanel() {

		AdvertController advertController = new AdvertController();

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

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {

				spotifyGrupo4.db.pojo.Record record = advertController.chooseRandomAdvert(advertController.getAll());

				changeGroupNameLbl(lblBandName, record);
				changeRecordDateLbl(lblPublicationDate, record);
				changeRecordGenreLbl(lblGenre, record);
				changeRecordImageLbl(lblAdvertisementImage, record);
				changeRecordTitleLbl(lblDiscTitle, record);
			}
		});
	}

	private void changeRecordTitleLbl(JLabel recordTitle, spotifyGrupo4.db.pojo.Record record) {
		recordTitle.setText(record.getTitle());
	}

	private void changeRecordImageLbl(JLabel recordInage, spotifyGrupo4.db.pojo.Record record) {
		recordInage.setText(record.getRecordCover());
	}

	private void changeRecordDateLbl(JLabel recordDate, spotifyGrupo4.db.pojo.Record record) {
		recordDate.setText(record.getReleaseDate().toGMTString());
	}

	private void changeGroupNameLbl(JLabel groupName, spotifyGrupo4.db.pojo.Record record) {
		groupName.setText(record.getBand().getName());
	}

	private void changeRecordGenreLbl(JLabel recordGenre, spotifyGrupo4.db.pojo.Record record) {
		recordGenre.setText(record.getGenre());
	}
}
