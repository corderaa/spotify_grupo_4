package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.db.pojo.Band;



public class BandPanel extends PanelAbstract {
	private DefaultTableModel modelSummary;
	private static final long serialVersionUID = -2104349749800899166L;
	
private void displaySelectedBandOnTable(ArrayList<Band> selectedBand) {
		if (selectedBand != null) {
				for (int i = 0; i < selectedBand.size(); i++) {
					if (selectedBand.get(i) != null) {

						

						// TODO CAMBIAR A OBJECT[]
						String[] row = { selectedBand.get(i).getName(),
								selectedBand.get(i).getName(),
								selectedBand.get(i).getDescription(),
								selectedBand.get(i).getImage()};

						modelSummary.addRow(row);
					}
				}
			}
		}
	
	public BandPanel(List<JPanel> panels) {
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
	}
}
