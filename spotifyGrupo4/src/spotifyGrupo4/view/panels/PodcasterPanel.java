package spotifyGrupo4.view.panels;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.db.managers.PodcasterManager;
import spotifyGrupo4.db.pojo.Podcaster;
import spotifyGrupo4.view.ExceptionHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class PodcasterPanel extends PanelAbstract {

	private static final long serialVersionUID = 2149713935271155679L;

	PodcasterManager podcasterManager = null;

	public PodcasterPanel(List<JPanel> panels) {
		podcasterManager = new PodcasterManager();
		getLblTitle().setText("podcaster");
		getModel().addColumn("name");
		getModel().addColumn("reproduction Number");
		getModel().addColumn("registration date");
		getModel().addColumn("description");

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
				List<Podcaster> podcasters = podcasterManager.getAll();
				fillTable(getModel(), podcasters);
			}
		});
	}

	private void fillTable(DefaultTableModel model, List<Podcaster> podcasters) {
		try {
			if (getModel().getRowCount() == 0) {
				for (Podcaster podcaster : podcasters) {
					Object[] linea = { podcaster.getName(), podcaster.getReproduction(),
							podcaster.getRegistrationDate(), podcaster.getDescription() };

					model.addRow(linea);
				}
			}
		} catch (Exception e) {
			ExceptionHandler.handleGenericException(e, "ERROR THERE ARE NO PODCASTERS" + e.getMessage());
		}
	}
}
