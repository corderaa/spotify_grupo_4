package spotifyGrupo4.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import spotifyGrupo4.db.managers.PodcasterManager;
import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.pojo.Podcaster;
import spotifyGrupo4.utils.DateConverter;

class PodcasterTests {

	@Test
	void getAllPodcasterTest() {
		List<Podcaster> podcasters = null;
		Band band = new Band();

		try {
			podcasters = new PodcasterManager().getAll();
			for (Podcaster podcaster : podcasters) {
				assertNotEquals(band, podcaster);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertPodcasterTest() {
		int podcasterId = 10;
		String podcasterName = "test";
		Date podcasterRegistrationDate = new Date();

		try {
			Podcaster podcasterTest = new Podcaster();
			podcasterTest.setId(podcasterId);
			podcasterTest.setName(podcasterName);
			podcasterTest.setRegistrationDate(DateConverter.utilDateToSqlDate(podcasterRegistrationDate));

			new PodcasterManager().insert(podcasterTest);

			assertEquals(new PodcasterManager().getOne(podcasterTest), podcasterTest);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void deletePodcasterTest() {
		int podcasterId = 20;
		String podcasterName = "test2";
		Date podcasterRegistrationDate = new Date();

		try {
			Podcaster podcasterTest = new Podcaster();
			podcasterTest.setId(podcasterId);
			podcasterTest.setName(podcasterName);
			podcasterTest.setRegistrationDate(DateConverter.utilDateToSqlDate(podcasterRegistrationDate));
			new PodcasterManager().insert(podcasterTest);
			new PodcasterManager().delete(podcasterTest);

			assertNull(new PodcasterManager().getOne(podcasterTest));

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void updatePodcasterTest() {
		int podcasterId = 40;
		String podcasterName = "test3";
		String podcasterNameUpdated = "testUpdated";
		Date podcasterRegistrationDate = new Date();

		try {
			Podcaster podcasterTest = new Podcaster();
			podcasterTest.setId(podcasterId);
			podcasterTest.setName(podcasterName);
			podcasterTest.setRegistrationDate(DateConverter.utilDateToSqlDate(podcasterRegistrationDate));
			new PodcasterManager().insert(podcasterTest);
			new PodcasterManager().modify(podcasterTest, podcasterNameUpdated);

			assertNotEquals(new PodcasterManager().getOne(podcasterTest).getName(), podcasterName);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
