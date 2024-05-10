package spotifyGrupo4.view.panels;

import javax.swing.JPanel;

import spotifyGrupo4.db.managers.PodcasterManager;
import spotifyGrupo4.db.pojo.Podcast;
import spotifyGrupo4.db.pojo.Podcaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PodcasterPanel extends PanelAbstract {

	private static final long serialVersionUID = 2149713935271155679L;

	PodcasterManager podcasterManager = null;

	public PodcasterPanel(List<JPanel> panels) {
		podcasterManager = new PodcasterManager();
		getLblTitle().setText("podcaster");

		
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
	}

	private void fillTable() {
		List<Podcaster> podcasters = podcasterManager.getAll();
		
		
	}
}
