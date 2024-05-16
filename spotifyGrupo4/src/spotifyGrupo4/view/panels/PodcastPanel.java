package spotifyGrupo4.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import spotifyGrupo4.controllers.Session;
import spotifyGrupo4.db.managers.PodcastManager;
import spotifyGrupo4.db.managers.PodcasterManager;
import spotifyGrupo4.db.managers.SongManager;
import spotifyGrupo4.db.pojo.Podcast;
import spotifyGrupo4.db.pojo.Song;
import spotifyGrupo4.view.ExceptionHandler;

public class PodcastPanel extends PanelAbstract {

	private static final long serialVersionUID = -3076849397835644353L;

	private PodcastManager podcastManager = null;
	private List<Podcast> podcasts = null;

	public PodcastPanel(List<JPanel> panels) {
		setBounds(309, 0, 953, 618);
		setLayout(null);

		podcastManager = new PodcastManager();
		getLblTitle().setText("Podcast");
		getModel().addColumn("Title");
		getModel().addColumn("duration");
		getModel().addColumn("numberReproductions");
		getModel().addColumn("contentType");

		getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getModel().setRowCount(0);
				panels.get(0).setVisible(false);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(true);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				panels.get(6).setVisible(false);
			}
		});

		getTable().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				Session.getInstance().setSelectedContent(podcasts.get(getTable().getSelectedRow()));
			}

		});

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				try {
					podcasts = podcastManager.getPodcastFromSeries(Session.getInstance().getSelectedSerie());
					fillPodcastTable(getModel(), podcasts);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
	}

	public void fillPodcastTable(DefaultTableModel podcastPanel, List<Podcast> podcasts) {
		try {
			getModel().setRowCount(0);
			if (getModel().getRowCount() == 0) {
				for (Podcast podcast : podcasts) {
					Object[] linea = { podcast.getTitle(), podcast.getDuration(), podcast.getReproductions(),
							podcast.getContentType() };

					podcastPanel.addRow(linea);

				}
			}
		} catch (Exception e) {
			ExceptionHandler.handleGenericException(e, "ERROR: " + e.getMessage());
		}
	}
}
