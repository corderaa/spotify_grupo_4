package spotifyGrupo4.view.panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class PanelAbstract extends JPanel {

	private static final long serialVersionUID = -2430219352548881282L;

	private JLabel lblTitle = null;

	public PanelAbstract() {

		setBounds(309, 0, 953, 618);
		setBackground(new Color(153, 255, 153));
		setLayout(null);

		lblTitle = new JLabel();
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(402, 276, 148, 65);
		add(lblTitle);
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

}
