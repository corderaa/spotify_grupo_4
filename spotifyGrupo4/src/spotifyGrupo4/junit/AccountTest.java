package spotifyGrupo4.junit;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import spotifyGrupo4.db.managers.AccountManager;
import spotifyGrupo4.db.managers.FreeAccountManager;
import spotifyGrupo4.db.managers.PodcasterManager;
import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.Podcaster;

class AccountTest {

	@Test
	void insertAccountTest() {

		int accountId = 2;
		String accountname = "test";
		Date lastLitenTimeDate = new Date();

		try {
			FreeAccount accountTest = new FreeAccount();
			accountTest.setId(accountId);
			accountTest.setName(accountname);
			accountTest.setLastListenedContent(lastLitenTimeDate);

			assertSame(lastLitenTimeDate, accountTest);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void updateAccountTest() {
		int accountId = 40;
		String accountname = "test3";
		String accountnameUpdated = "test3Updated";
		Date lastLitenTimeDate = new Date();

		try {
			FreeAccount accountTest = new FreeAccount();
			accountTest.setId(accountId);
			accountTest.setName(accountname);
			accountTest.setLastListenedContent(lastLitenTimeDate);
			new FreeAccountManager().insert(accountTest);
			new FreeAccountManager().updatePassword(accountTest, accountnameUpdated);

			assertNotEquals(new FreeAccountManager().getOne(accountTest).getName(), accountname);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
