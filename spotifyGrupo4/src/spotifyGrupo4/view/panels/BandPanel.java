package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import spotifyGrupo4.view.panels.RecordPanel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import spotifyGrupo4.db.pojo.Record;
import spotifyGrupo4.db.managers.BandManager;
import spotifyGrupo4.db.managers.RecordManager;
import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.view.ExceptionHandler;

public class BandPanel extends PanelAbstract {

	private static final long serialVersionUID = -2104349749800899166L;
	RecordManager recordManager = null;
	BandManager bandManager = null;

	public BandPanel(List<JPanel> panels) {
		RecordPanel recordPanel = new RecordPanel(panels);

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
		getTable().addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent e) {

		    	int row = getTable().rowAtPoint(e.getPoint());
		        if (row >= 0 && e.getClickCount() == 2) {
		            if (recordPanel != null) {
		                DefaultTableModel model = (DefaultTableModel) getTable().getModel();
		                recordPanel.fillRecordTale(model);
		                panels.get(0).setVisible(false);
						panels.get(1).setVisible(false);
						panels.get(2).setVisible(false);
						panels.get(3).setVisible(true);
						panels.get(4).setVisible(false);
						panels.get(5).setVisible(false);
						panels.get(6).setVisible(false);
		            }
		        }
		    }
		});


		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				List<Band> band = bandManager.getAll();
				fillBandTable(getModel(), band);
			}
		});
	}
	
	private void fillBandTable(DefaultTableModel model, List<Band> bands) {
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