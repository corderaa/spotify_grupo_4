package spotifyGrupo4.junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import spotifyGrupo4.db.managers.BandManager;
import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.pojo.Podcaster;
import spotifyGrupo4.utils.DateConverter;

class BandTest {

	@Test
	void getAllManagerTest() {
		List<Band> bands = null;
		Podcaster podcaster = new Podcaster();

		try {
			bands = new BandManager().getAll();
			for (Band band : bands) {
				assertNotEquals(podcaster, band);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertBandTest() {
		int bandId = 1;
		String bandName = "test";
		Date bandCreationsDate = new Date();

		try {
			Band bandTest = new Band();
			bandTest.setId(bandId);
			bandTest.setName(bandName);
			bandTest.setCreationDate(DateConverter.utilDateToSqlDate(bandCreationsDate));

			new BandManager().insert(bandTest);
			assertSame(bandCreationsDate, bandTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void deleteBandTest() throws SQLException {
		int bandId = 20;
		String bandName = "test2";
		Date bandRegistrationDate = new Date();

		try {
			Band bandTest = new Band();
			bandTest.setId(bandId);
			bandTest.setName(bandName);
			bandTest.setCreationDate(DateConverter.utilDateToSqlDate(bandRegistrationDate));
			new BandManager().insert(bandTest);
			new BandManager().delete(bandTest);

			assertNull(new BandManager().getOne(bandTest));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void updateBandTest() throws SQLException {
		int bandId = 40;
		String bandName = "test3";
		String bandNameUpdated = "testUpdated";
		Date bandRegistrationDate = new Date();

		try {
			Band bandTest = new Band();
			bandTest.setId(bandId);
			bandTest.setName(bandName);
			bandTest.setCreationDate(DateConverter.utilDateToSqlDate(bandRegistrationDate));
			new BandManager().insert(bandTest);
			new BandManager().modify(bandTest, bandNameUpdated);

			assertNotEquals(new BandManager().getOne(bandTest).getName(), bandName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
