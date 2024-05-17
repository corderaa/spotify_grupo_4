package spotifyGrupo4.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import spotifyGrupo4.db.managers.RecordManager;

public class AdvertController implements ControllerInterface<spotifyGrupo4.db.pojo.Record> {

	private RecordManager recordManager = null;

	public AdvertController() {
		recordManager = new RecordManager();
	}

	@Override
	public List<spotifyGrupo4.db.pojo.Record> getAll() throws SQLException, Exception {
		return recordManager.getAllWithBand();
	}

	@Override
	public void insert(spotifyGrupo4.db.pojo.Record t) {
	}

	@Override
	public void update(spotifyGrupo4.db.pojo.Record t) {
	}

	@Override
	public void delete(spotifyGrupo4.db.pojo.Record t) {
	}

	public spotifyGrupo4.db.pojo.Record chooseRandomAdvert(List<spotifyGrupo4.db.pojo.Record> records) {

		return records.get((int) new Random().nextInt(records.size() - 1));
	}
}
