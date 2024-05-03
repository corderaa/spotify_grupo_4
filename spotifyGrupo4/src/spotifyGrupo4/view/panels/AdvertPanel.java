package spotifyGrupo4.view.panels;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import spotifyGrupo4.controllers.AdvertController;

public class AdvertPanel extends JPanel {

	private static final long serialVersionUID = -8354352845486534109L;

	public AdvertPanel() {

		AdvertController advertController = new AdvertController();

		setBounds(309, 0, 953, 618);
		setBackground(new Color(159, 203, 217));
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

				spotifyGrupo4.db.pojo.Record record = handleGetAllRecords(advertController);

				if (null != record) {
					changeRecordDateLbl(lblPublicationDate, record);
					changeRecordGenreLbl(lblGenre, record);
					changeRecordImageLbl(lblAdvertisementImage, record);
					changeRecordTitleLbl(lblDiscTitle, record);
					changeGroupNameLbl(lblBandName, record);
				}
			}
		});
	}

	private void changeRecordTitleLbl(JLabel recordTitle, spotifyGrupo4.db.pojo.Record record) {
		recordTitle.setText(record.getTitle());
	}

	private void changeRecordImageLbl(JLabel recordInage, spotifyGrupo4.db.pojo.Record record) {
		recordInage.setText(record.getRecordCover());
	}

	@SuppressWarnings("deprecation")
	private void changeRecordDateLbl(JLabel recordDate, spotifyGrupo4.db.pojo.Record record) {
		recordDate.setText(record.getReleaseDate().toGMTString());
	}

	private void changeGroupNameLbl(JLabel groupName, spotifyGrupo4.db.pojo.Record record) {
		groupName.setText(record.getBand().getName());
	}

	private void changeRecordGenreLbl(JLabel recordGenre, spotifyGrupo4.db.pojo.Record record) {
		recordGenre.setText(record.getGenre());
	}

	private spotifyGrupo4.db.pojo.Record handleGetAllRecords(AdvertController advertController) {
		spotifyGrupo4.db.pojo.Record record = null;
		try {
			record = advertController.chooseRandomAdvert(advertController.getAll());
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return record;
	}
}
