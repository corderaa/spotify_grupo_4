package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.db.pojo.Record;
import spotifyGrupo4.db.managers.RecordManager;
import spotifyGrupo4.view.ExceptionHandler;

public class RecordPanel extends PanelAbstract {

	private static final long serialVersionUID = 683877449051207298L;
	
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
				panels.get(0).setVisible(true);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
			}
		});
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
					fillRecordTale(getModel());
			}
		});
		}
	public void fillRecordTale(DefaultTableModel model) {
		try {
			List<Record> records = recordManager.getAllWithBand();
			if (getModel().getRowCount() == 0) {
				for (Record record : records) {
					Object[] linea = { record.getTitle(), record.getRecordCover(), record.getGenre(),
							record.getReleaseDate(), record.getNumberReproductions() };

					model.addRow(linea);
				}
			}
		} catch (Exception e) {
			ExceptionHandler.handleGenericException(e, "ERROR: " + e.getMessage());
		}
	}
}
