package spotifyGrupo4.db.managers;

import java.sql.SQLException;
import java.util.Date;

import spotifyGrupo4.db.pojo.Account;

public class AccountManager implements AccountInterface<Account> {

	@Override
	public Account getByLogin(String login) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLastLogin(Account t, Date currentDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIsBloqued(Account t, Boolean bloqued) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(Account t, String password) {
		// TODO Auto-generated method stub
		
	}

}
