package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.controllers.Session;
import spotifyGrupo4.db.managers.SongManager;
import spotifyGrupo4.db.pojo.Song;
import spotifyGrupo4.view.ExceptionHandler;

public class SongPanel extends PanelAbstract {
  
	private static final long serialVersionUID = -1754009495368908597L;
	SongManager songManager = null;
	public SongPanel(List<JPanel> panels) {

		songManager = new SongManager();
		getLblTitle().setText("Song");
		getModel().addColumn("Content Id");
		getModel().addColumn("Title");
		getModel().addColumn("Duration");
		getModel().addColumn("Number Reproductions");

		setBounds(309, 0, 953, 618);
		setLayout(null);

		JLabel lblSongTitle = new JLabel(" SONG TITLE");
		lblSongTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSongTitle.setBounds(82, 204, 576, 163);
		add(lblSongTitle);

		JLabel lblReproductionNumber = new JLabel("REPRODUCTION NUMBER");
		lblReproductionNumber.setBounds(692, 204, 180, 163);
		add(lblReproductionNumber);

		JLabel lblDuration = new JLabel("DURATION");
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setBounds(82, 429, 576, 149);
		add(lblDuration);

		songManager= new SongManager();
		getLblTitle().setText("Songs");
		getModel().addColumn("Title");
		getModel().addColumn("duration");
		getModel().addColumn("numberReproductions");
		getModel().addColumn("contentType");
		
		
		getBtnBack().addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				getModel().setRowCount(0);
				panels.get(0).setVisible(true);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
			}
		});
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				List<Song> songs;
				try {
					songs = songManager.getSongsFromRecord(Session.getInstance().getSelectedRecord());
					fillSongTable(getModel(), songs);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}
	
	public void fillSongTable(DefaultTableModel songPanel, List<Song> songs) {
		try {
			getModel().setRowCount(0);
			if (getModel().getRowCount() == 0) {
				for (Song song : songs) {
					Object[] linea = { song.getTitle(), song.getDuration(), song.getReproductions(),
							song.getContentType()};

					songPanel.addRow(linea);

				}
			}

		} catch (Exception e) {
			ExceptionHandler.handleGenericException(e, "ERROR: " + e.getMessage());
		}
	}
}
