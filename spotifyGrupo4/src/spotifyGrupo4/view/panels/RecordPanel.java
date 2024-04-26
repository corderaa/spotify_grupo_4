package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

public class RecordPanel extends PanelAbstract {

	private static final long serialVersionUID = 683877449051207298L;

	public RecordPanel(List<JPanel> panels) {
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
	}
}
