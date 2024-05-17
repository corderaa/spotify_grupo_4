package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.controllers.AdminController;
import spotifyGrupo4.controllers.PlaylistController;
import spotifyGrupo4.db.pojo.Band;

public class AdminPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable tableCreators;
	private JPopupMenu popup;
	private JTable tableContent;

	public AdminPanel(List<JPanel> panels) {

		setBounds(309, 0, 953, 618);
		setBackground(new Color(102, 205, 170));
		setLayout(null);

		JScrollPane scrollPlaylists = new JScrollPane();
		scrollPlaylists.setBounds(167, 50, 573, 150);
		add(scrollPlaylists);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Artist");
		model.addColumn("Likes");

		table = new JTable(model);
		scrollPlaylists.setViewportView(table);

		JScrollPane scrollCreatorss = new JScrollPane();
		scrollCreatorss.setBounds(167, 50, 573, 300);
		add(scrollCreatorss);

		DefaultTableModel modelCreators = new DefaultTableModel();
		modelCreators.addColumn("Id");
		modelCreators.addColumn("Artist");
		modelCreators.addColumn("Description");
		modelCreators.addColumn("Reproduction");

		tableCreators = new JTable(modelCreators);
		scrollCreatorss.setViewportView(tableCreators);

		JScrollPane scrollPlaylistsContent = new JScrollPane();
		scrollPlaylistsContent.setBounds(167, 250, 573, 200);
		add(scrollPlaylistsContent);

		DefaultTableModel creatorModel = new DefaultTableModel();
		creatorModel.addColumn("Artist");
		creatorModel.addColumn("Num. Reproductions");

		tableContent = new JTable(creatorModel);
		scrollPlaylistsContent.setViewportView(tableContent);

		scrollCreatorss.setVisible(false);
		scrollPlaylists.setVisible(false);
		scrollPlaylistsContent.setVisible(false);

		popup = new JPopupMenu();
		JMenuItem menuDelete = new JMenuItem("Delete");
		menuDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTable table;
				try {
					Component c = (Component) e.getSource();
					JPopupMenu popup = (JPopupMenu) c.getParent();
					table = (JTable) popup.getInvoker();
					int column = 0;
					int row = table.getSelectedRow();
					int value = Integer.parseInt((table.getModel().getValueAt(row, column)).toString());
					new AdminController().erase(value);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		popup.add(menuDelete);

		JMenuItem menuCreateOne = new JMenuItem("Edit");
		menuCreateOne.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Component c = (Component) e.getSource();
				JPopupMenu popup = (JPopupMenu) c.getParent();
				JTable table = (JTable) popup.getInvoker();
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
			}
		});

		popup.add(menuCreateOne);

		tableCreators.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					JTable source = (JTable) e.getSource();
					int row = source.rowAtPoint(e.getPoint());
					int column = source.columnAtPoint(e.getPoint());

					if (!source.isRowSelected(row))
						source.changeSelection(row, column, false, false);

					popup.show(e.getComponent(), e.getX(), e.getY());

				}
			}
		});

		table.setPreferredScrollableViewportSize(table.getPreferredSize());

		JButton btnseeFavourites = new JButton("Favourites");
		btnseeFavourites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPlaylists.setVisible(false);
				scrollPlaylistsContent.setVisible(true);
				scrollCreatorss.setVisible(false);

				try {

					ArrayList<Band> playlists = new AdminController().seeMostLiked();

					showCreators(model, playlists);

					new PlaylistController().getAllPlaylistsFromAccount(2);
				} catch (SQLException e1) {

				} catch (Exception e1) {
				}

			}
		});
		btnseeFavourites.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnseeFavourites.setBounds(770, 470, 110, 40);
		add(btnseeFavourites);

		JButton btnseePlayed = new JButton("Most played");
		btnseePlayed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPlaylists.setVisible(true);
				scrollPlaylistsContent.setVisible(false);
				scrollCreatorss.setVisible(false);
				try {

					ArrayList<Band> playlists = new AdminController().seeMostViewed();

					showCreators(creatorModel, playlists);

					new PlaylistController().getAllPlaylistsFromAccount(2);
				} catch (SQLException e1) {
				} catch (Exception e1) {
				}

			}
		});
		btnseePlayed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnseePlayed.setBounds(770, 389, 110, 40);
		add(btnseePlayed);

		JButton btnAddNewPlaylist = new JButton("Add new  Creator");
		btnAddNewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					var argCreaotorName = javax.swing.JOptionPane.showInputDialog("Write a name.");
					var arg_Formation = javax.swing.JOptionPane.showInputDialog("date of Formation.");
					var arg_About = javax.swing.JOptionPane.showInputDialog("Write a Description");
					var arg_members = javax.swing.JOptionPane.showInputDialog("if its a band, write num members");
					var arg_image = javax.swing.JOptionPane.showInputDialog("Path to find the image");

					if (argCreaotorName == null || arg_About == null || arg_Formation == null || arg_members == null
							|| arg_image == null)
						return;
					else

						new AdminController().castInput(argCreaotorName, arg_Formation, arg_About, arg_members,
								arg_image);
					;
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddNewPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddNewPlaylist.setBounds(770, 312, 110, 40);
		add(btnAddNewPlaylist);

		JButton btnClear = new JButton("Clear Lists");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.setRowCount(0);
				creatorModel.setRowCount(0);
				modelCreators.setRowCount(0);

			}
		});
		btnClear.setBounds(770, 520, 100, 23);
		add(btnClear);

		JButton btnAllCreators = new JButton("List All");
		btnAllCreators.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPlaylists.setVisible(false);
				scrollPlaylistsContent.setVisible(false);
				scrollCreatorss.setVisible(true);
				try {

					ArrayList<Band> playlists = new AdminController().seeAllCreator();

					showAllCreators(modelCreators, playlists);

					new PlaylistController().getAllPlaylistsFromAccount(2);
				} catch (SQLException e1) {
				} catch (Exception e1) {
				}

			}

			private void showAllCreators(DefaultTableModel modelCreators, ArrayList<Band> playlists) {

				modelCreators.setRowCount(0);
				for (Band band : playlists) {
					String[] linea = { String.valueOf(band.getId()), band.getName(), band.getDescription(),
							String.valueOf(band.getReproduction()) };
					modelCreators.addRow(linea);
				}

			}
		});
		btnAllCreators.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAllCreators.setBounds(770, 259, 110, 40);
		add(btnAllCreators);

	}

	public void showCreators(DefaultTableModel modelo, ArrayList<Band> playlists) {
		modelo.setRowCount(0);
		for (Band band : playlists) {
			String[] linea = { band.getName(), String.valueOf(band.getId()) };
			modelo.addRow(linea);
		}

	}
}
