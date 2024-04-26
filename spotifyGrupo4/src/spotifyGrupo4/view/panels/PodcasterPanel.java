package spotifyGrupo4.view.panels;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PodcasterPanel extends PanelAbstract {

	private static final long serialVersionUID = 2149713935271155679L;

	public PodcasterPanel(List<JPanel> panels) {
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
}
