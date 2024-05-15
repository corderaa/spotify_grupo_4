package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.pojo.Record;
import spotifyGrupo4.controllers.Session;
import spotifyGrupo4.db.managers.RecordManager;
import spotifyGrupo4.view.ExceptionHandler;

public class RecordPanel extends PanelAbstract {

	private static final long serialVersionUID = 683877449051207298L;
	private List<Record> record = null;
	RecordManager recordManager = null;

	public RecordPanel(List<JPanel> panels) {

		recordManager = new RecordManager();
		getLblTitle().setText("Record");
		getModel().addColumn("Title");
		getModel().addColumn("RecordCover");
		getModel().addColumn("Genre");
		getModel().addColumn("ReleaseDate");
		getModel().addColumn("NumberReproductions");

		getBtnBack().addActionListener(new ActionListener() {
 
			public void actionPerformed(ActionEvent e) {
				getModel().setRowCount(0);
				panels.get(0).setVisible(true);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
			}
		});
		getTable().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				
//				Session.getInstance().setSelectedRecord(record.get(getTable().getSelectedRow()));
				
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(true);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
			}

		});
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				List<Record> records;
				try {
					records = recordManager.getRecordsFromBand(Session.getInstance().getSelectedBand());
					fillRecordTable(getModel(), records);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}

	public void fillRecordTable(DefaultTableModel recordPanel, List<Record> records) {
		try {
			getModel().setRowCount(0);
			if (getModel().getRowCount() == 0) {
				for (Record record : records) {
					Object[] linea = { record.getTitle(), record.getRecordCover(), record.getGenre(),
							record.getReleaseDate(), record.getNumberReproductions() };

					recordPanel.addRow(linea);

				}
			}

		} catch (Exception e) {
			ExceptionHandler.handleGenericException(e, "ERROR: " + e.getMessage());
		}
	}
}
