package spotifyGrupo4.view.panels;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.controllers.PlaylistController;
import spotifyGrupo4.controllers.Session;
import spotifyGrupo4.db.managers.PlayListManager;
import spotifyGrupo4.db.pojo.Content;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.Playlist;
import spotifyGrupo4.db.pojo.PremiumAccount;
import spotifyGrupo4.utils.FileManager;

public class MisFavoritos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPopupMenu popup;
	private JTable tableContent;

	/**
	 * Create the panel.
	 */
	public MisFavoritos(List<JPanel> panels) {

		setBounds(309, 0, 953, 618);
		setBackground(new Color(102, 205, 170));
		setLayout(null);

		JScrollPane scrollPlaylists = new JScrollPane();
		scrollPlaylists.setBounds(167, 50, 573, 150);
		add(scrollPlaylists);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("idPalylist");
		modelo.addColumn("Title");

		table = new JTable(modelo);
		scrollPlaylists.setViewportView(table);

		JScrollPane scrollPlaylistsContent = new JScrollPane();
		scrollPlaylistsContent.setBounds(167, 200, 573, 200);
		add(scrollPlaylistsContent);

		DefaultTableModel modeloCanciones = new DefaultTableModel();
		modeloCanciones.addColumn("Title");
		modeloCanciones.addColumn("legnth");
		modeloCanciones.addColumn("Num. Reproductions");
		tableContent = new JTable(modeloCanciones);
		scrollPlaylistsContent.setViewportView(tableContent);

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
					new PlaylistController().erase(value);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		popup.add(menuDelete);
		JMenuItem menuCreateOne = new JMenuItem("Any other Option");
		menuCreateOne.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Component c = (Component) e.getSource();
				JPopupMenu popup = (JPopupMenu) c.getParent();
				JTable table = (JTable) popup.getInvoker();
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				System.out.println(value);
			}
		});

		popup.add(menuCreateOne);
		JMenuItem menuViewContent = new JMenuItem("ViewContent");
		menuViewContent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTable table;
				try {

					Component c = (Component) e.getSource();
					JPopupMenu popup = (JPopupMenu) c.getParent();
					table = (JTable) popup.getInvoker();
					int column = 0;
					int row = table.getSelectedRow();
					int value = Integer.parseInt((table.getModel().getValueAt(row, column)).toString());
					ArrayList<Content> content = new PlaylistController().getOneListContent(value);
					showOnePlaylist(modeloCanciones, content);

				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		popup.add(menuViewContent);

		table.addMouseListener(new MouseAdapter() {
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

		JButton btnseeAllPlaylists = new JButton("See Playlists");
		btnseeAllPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					ArrayList<Playlist> playlists = new PlaylistController()
							.getAllPlaylistsFromAccount(Session.getInstance().getAccount().getId());

					showPlaylist(modelo, playlists);

					new PlaylistController().getAllPlaylistsFromAccount(2);
				} catch (SQLException e1) {
				} catch (Exception e1) {
				}

			}
		});
		btnseeAllPlaylists.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnseeAllPlaylists.setBounds(750, 389, 131, 58);
		add(btnseeAllPlaylists);

		JButton btnExport = new JButton("Export Playlists");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Playlist> playlists = new PlaylistController()
							.getAllPlaylistsFromAccount(Session.getInstance().getAccount().getId());
					new FileManager().writeObject(playlists,
							String.valueOf(Session.getInstance().getAccount().getId()));

					new PlaylistController().getAllPlaylistsFromAccount(Session.getInstance().getAccount().getId());
				} catch (SQLException e1) {

				} catch (Exception e1) {

				}
			}
		});

		btnExport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExport.setBounds(750, 477, 131, 58);
		add(btnExport);

		JButton btnImport = new JButton("Import Playlists");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					@SuppressWarnings("unchecked")
					ArrayList<Playlist> playlists = (ArrayList<Playlist>) new FileManager()
							.readObject(String.valueOf(Session.getInstance().getAccount().getId()));
					showPlaylist(modelo, playlists);
				} catch (Exception e1) {
					System.out.println("Import Failed");
					e1.printStackTrace();
				}

			}
		});
		btnImport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImport.setBounds(750, 546, 131, 58);
		add(btnImport);

		JButton btnAddNewPlaylist = new JButton("Add new  Playist");
		btnAddNewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					var title = javax.swing.JOptionPane.showInputDialog("Write a name to indenity the playlist?");
					if (title == null)
						return;
					new PlayListManager().createPlaylist(Session.getInstance().getAccount().getId(), title.trim());
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
		btnAddNewPlaylist.setBounds(762, 312, 120, 50);
		add(btnAddNewPlaylist);

	}

	public void showOnePlaylist(DefaultTableModel modeloCanciones, ArrayList<Content> playlist) {
		modeloCanciones.setRowCount(0);

		for (Content content : playlist) {
			String[] linea = { content.getTitle(), "pending to convert date time",
					String.valueOf(content.getReproductions()) };
			modeloCanciones.addRow(linea);
		}

	}

	public void showPlaylist(DefaultTableModel modelo, ArrayList<Playlist> playlists) {
		modelo.setRowCount(0);
		for (Playlist playlist : playlists) {
			String[] linea = { String.valueOf(playlist.getPlaylistId()), playlist.getTitle() };
			modelo.addRow(linea);
		}

	}

}
