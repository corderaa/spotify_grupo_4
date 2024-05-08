package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.PremiumAccount;
import spotifyGrupo4.db.utils.DBUtils;

public class AccountManager implements AccountInterface<Account> {

	@Override
	public Account getByLogin(Account account) throws SQLException, Exception {
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

	/**
	 * Get user from the database
	 * 
	 * @param dni
	 * @param password
	 * @return
	 */

	public Account getUser(String dni, String password) {

		Account ret = null;

		Connection connection = null;

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "SELECT * FROM account WHERE accountdni = ? AND accountPassword = ?";

			statement = connection.prepareStatement(sql);
			statement.setString(1, dni);
			statement.setString(2, password);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				if (resultSet.getString("accountType").equalsIgnoreCase("premium")) {
					ret = new PremiumAccount();
				} else if (resultSet.getString("accountType").equalsIgnoreCase("free")) {
					ret = new FreeAccount();
				}
				if (resultSet.getString("accountType").equalsIgnoreCase("admin")) {
					ret = new PremiumAccount();
				}

				ret.setId(resultSet.getInt("accountId"));
				ret.setDni(resultSet.getString("accountdni"));
				ret.setName(resultSet.getString("accountname"));
				ret.setAccountType(resultSet.getString("accountType"));
				ret.setMiddleName(resultSet.getString("accountmiddleName"));
				ret.setSurName(resultSet.getString("accountsurname"));
				ret.setBirthDate(resultSet.getDate("accountbirthDate"));
				ret.setPostalCode(resultSet.getInt("accountpostCode"));
				ret.setCity(resultSet.getString("accountcity"));
				ret.setCountry(resultSet.getString("accountcountry"));
				ret.setPassword(resultSet.getString("accountPassword"));

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}

		return ret;
	}
}
