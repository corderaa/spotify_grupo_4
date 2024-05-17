package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.AdminAccount;
import spotifyGrupo4.db.utils.DBUtils;

public class AdminAccountManager implements AccountInterface<AdminAccount>, InterfaceManager<AdminAccount> {

	@Override
	public List<AdminAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(AdminAccount t) {
		// TODO Auto-generated method stub

	}

	@Override
	public AdminAccount getOne(AdminAccount t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminAccount getByLogin(String dni) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLastLogin(AdminAccount t, Date currentDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateIsBloqued(String dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(AdminAccount t, String password) throws SQLException, Exception {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			String sql = "update reto4_grupo4.account set account.accountPassword = '" + password
					+ "' where account.accountId = " + t.getId();

			statement.executeUpdate(sql);

		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}

	}

}
