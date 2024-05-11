package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.db.managers.BandManager;
import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.view.ExceptionHandler;

public class BandPanel extends PanelAbstract {

	private static final long serialVersionUID = -2104349749800899166L;

	BandManager bandManager = null;

	public BandPanel(List<JPanel> panels) {

		bandManager = new BandManager();
		getLblTitle().setText("Band");
		getModel().addColumn("Members");
		getModel().addColumn("Creation Date");
		getModel().addColumn("Regristration Date");
		getModel().addColumn("Description");
		getModel().addColumn("Image");

		getLblTitle().setText("band");

		getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(true);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
			}
		});
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				List<Band> band = bandManager.getAll();
				fillTable(getModel(), band);
			}
		});
	}

	private void fillTable(DefaultTableModel model, List<Band> bands) {
		try {

			if (getModel().getRowCount() == 0) {
				for (Band band : bands) {
					Object[] linea = { band.getMembers(), band.getName(), band.getCreationDate(),
							band.getReproduction(), band.getDescription(), band.getImage() };

					model.addRow(linea);
				}
			}
		} catch (Exception e) {
			ExceptionHandler.handleGenericException(e, "ERROR THERE ARE NO BANDS" + e.getMessage());
		}

	}
}