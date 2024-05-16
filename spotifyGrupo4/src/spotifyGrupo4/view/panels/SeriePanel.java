package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.controllers.Session;
import spotifyGrupo4.db.managers.SerieManager;
import spotifyGrupo4.db.pojo.Serie;
import spotifyGrupo4.view.ExceptionHandler;

public class SeriePanel extends PanelAbstract {

	private static final long serialVersionUID = 3665584306436508080L;
	
	private List<Serie> series = null;

	SerieManager serieManager = null;

	public SeriePanel(List<JPanel> panels) {
		serieManager = new SerieManager();
		getLblTitle().setText("Serie");
		getModel().addColumn("Title");
		getModel().addColumn("First Episode Date");
		getModel().addColumn("Last Episode Date ");
		getModel().addColumn("theme");
		getModel().addColumn("description");

		getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getModel().setRowCount(0);
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(true);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
			}
		});
		getTable().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {

				Session.getInstance().setSelectedSerie(series.get(getTable().getSelectedRow()));

				panels.get(0).setVisible(false);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(true);
			}

		});
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				try {
					series = serieManager.getSeriesFromPodcaster(Session.getInstance().getSelectedPodcaster());
					fillSeriesTable(getModel(), series);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}

	public void fillSeriesTable(DefaultTableModel seriePanel, List<Serie> series) {
		try {
			getModel().setRowCount(0);
			if (getModel().getRowCount() == 0) {
				for (Serie serie : series) {
					Object[] linea = { serie.getTitle(), serie.getStartingDate(), serie.getFinishDate(),
							serie.getTheme(), serie.getDescription() };

					seriePanel.addRow(linea);

				}
			}

		} catch (Exception e) {
			ExceptionHandler.handleGenericException(e, "ERROR: " + e.getMessage());
		}

	}
}
