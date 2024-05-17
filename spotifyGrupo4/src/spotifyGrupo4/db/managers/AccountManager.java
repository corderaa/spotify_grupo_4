package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.AdminAccount;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.PremiumAccount;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

public class AccountManager implements AccountInterface<Account> {

	@Override
	public Account getByLogin(String dni) throws SQLException, Exception {

		Account ret = null;

		Connection connection = null;

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "SELECT * FROM account WHERE accountdni = ? ";

			statement = connection.prepareStatement(sql);
			statement.setString(1, dni);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				if (resultSet.getString("accountType").equalsIgnoreCase("premium")) {
					ret = new PremiumAccount();
				} else if (resultSet.getString("accountType").equalsIgnoreCase("free")) {
					ret = new FreeAccount();
				}
				if (resultSet.getString("accountType").equalsIgnoreCase("admin")) {
					ret = new AdminAccount();
				}

				ret.setId(resultSet.getInt("accountId"));
				ret.setDni(resultSet.getString("accountdni"));
				ret.setName(resultSet.getString("accountname"));
				ret.setAccountType(resultSet.getString("accountType"));
				ret.setMiddleName(resultSet.getString("accountmiddleName"));
				ret.setSurName(resultSet.getString("accountsurname"));
				ret.setBirthDate(resultSet.getDate("accountbirthDate"));
				ret.setIsBloqued(resultSet.getBoolean("isBlocked"));
				ret.setPostalCode(resultSet.getInt("accountpostCode"));
				ret.setCity(resultSet.getString("accountcity"));
				ret.setCountry(resultSet.getString("accountcountry"));
				ret.setPassword(resultSet.getString("accountPassword"));

			}
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

	@Override
	public void updateLastLogin(Account account, Date currentDate) throws SQLException, ClassNotFoundException {

		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			String sql = "update reto4_grupo4.account set account.last_login = '"
					+ DateConverter.utilDateToSqlDate(currentDate) + "' where account.accountId = " + account.getId();

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

	@Override
	public void updatePassword(Account t, String password) throws SQLException, Exception {

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

	/**
	 * Get user from the database
	 * 
	 * @param dni
	 * @param password
	 * @return
	 */

	public Account getUser(String dni, String password) throws SQLException, Exception {

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
					ret = new AdminAccount();
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

	@Override
	public void updateIsBloqued(String dni) throws SQLException, Exception {
		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			String sql = "update reto4_grupo4.account set account.isblocked = " + 1 + " where account.accountDni = '"
					+ dni + "'";

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
