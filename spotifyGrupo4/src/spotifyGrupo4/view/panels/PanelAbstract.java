package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class PanelAbstract extends JPanel {

	private static final long serialVersionUID = -2430219352548881282L;

	private JLabel lblTitle = null;
	private JTable table;
	private JScrollPane scrollPane = null;
	private JPanel subPanel = null;
	private JLabel lblImage = null;
	private JLabel lblName = null;
	private JLabel lblDate = null;
	private JLabel lblDescription = null;
	private JScrollPane scrollGroup = null;
	private JLabel lblReproductionNumber = null;
	private JButton btnBack = null;
	private DefaultTableModel model = null;

	public PanelAbstract() {

		setBounds(309, 0, 953, 618);
		setBackground(new Color(153, 255, 153));
		setLayout(null);

		lblTitle = new JLabel();
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(402, 276, 148, 65);
		add(lblTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 953, 618);
		add(scrollPane);

		subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(500, 1000));
		scrollPane.setViewportView(subPanel);
		subPanel.setLayout(null);

		lblImage = new JLabel("Group Image");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(224, 46, 486, 228);
		subPanel.add(lblImage);

		lblName = new JLabel("Group Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(59, 304, 146, 43);
		subPanel.add(lblName);

		lblDate = new JLabel("Creation Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(738, 304, 146, 43);
		subPanel.add(lblDate);

		scrollGroup = new JScrollPane();
		scrollGroup.setBounds(224, 415, 486, 329);
		subPanel.add(scrollGroup);

		
		model = new DefaultTableModel();
		table = new JTable(model);
		scrollGroup.setViewportView(table);
		table.setDefaultEditor(Object.class, null);


		lblDescription = new JLabel("Description");
		lblDescription.setBounds(224, 780, 486, 14);
		subPanel.add(lblDescription);

		lblReproductionNumber = new JLabel("Reproduction number");
		lblReproductionNumber.setBounds(224, 900, 486, 14);
		subPanel.add(lblReproductionNumber);

		btnBack = new JButton("Go Back");
		btnBack.setBounds(800, 950, 89, 23);
		subPanel.add(btnBack);
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JPanel getSubPanel() {
		return subPanel;
	}

	public void setSubPanel(JPanel subPanel) {
		this.subPanel = subPanel;
	}

	public JLabel getLblImage() {
		return lblImage;
	}

	public void setLblImage(JLabel lblImage) {
		this.lblImage = lblImage;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblDate() {
		return lblDate;
	}

	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public JLabel getLblDescription() {
		return lblDescription;
	}

	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}

	public JScrollPane getScrollGroup() {
		return scrollGroup;
	}

	public void setScrollGroup(JScrollPane scrollGroup) {
		this.scrollGroup = scrollGroup;
	}

	public JLabel getLblReproductionNumber() {
		return lblReproductionNumber;
	}

	public void setLblReproductionNumber(JLabel lblReproductionNumber) {
		this.lblReproductionNumber = lblReproductionNumber;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
