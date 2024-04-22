package spotifyGrupo4.db.managers;

import java.util.Date;
import java.util.List;

import spotifyGrupo4.db.pojo.FreeAccount;

public class FreeAccountManager implements AccountInterface<FreeAccount>, InterfaceManager<FreeAccount> {

	@Override
	public List<FreeAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(FreeAccount t) {
		// TODO Auto-generated method stub

	}

	@Override
	public FreeAccount getbyLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLastLogin(FreeAccount t, Date currentDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateIsBloqued(FreeAccount t, Boolean bloqued) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(FreeAccount t, String password) {
		// TODO Auto-generated method stub

	}

}
