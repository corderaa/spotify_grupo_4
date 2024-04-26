package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

public class SeriePanel extends PanelAbstract {

	private static final long serialVersionUID = 3665584306436508080L;

	public SeriePanel(List<JPanel> panels) {

		getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(true);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
			}
		});
	}
}
