package spotifyGrupo4.db.managers;

import java.util.Date;
import java.util.List;

import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.PremiumAccount;

public class PremiumAccountManager implements AccountInterface<PremiumAccount>, InterfaceManager<PremiumAccount> {

	@Override
	public List<PremiumAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PremiumAccount t) {
		// TODO Auto-generated method stub

	}

	@Override
	public PremiumAccount getbyLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLastLogin(PremiumAccount t, Date currentDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateIsBloqued(PremiumAccount t, Boolean bloqued) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(PremiumAccount t, String password) {
		// TODO Auto-generated method stub

	}

}
