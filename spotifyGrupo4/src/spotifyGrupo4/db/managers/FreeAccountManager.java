package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

public class FreeAccountManager implements AccountInterface<FreeAccount>, InterfaceManager<FreeAccount> {

	@Override
	public List<FreeAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(FreeAccount newUser) throws SQLException, Exception {
		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into account (accountdni, accountname, accountType, accountmiddleName, registryDate, accountsurname, accountbirthDate, accountpostCode, accountcity, accountcountry, accountPassword) VALUES ('"
					+ newUser.getDni() + "', '" + newUser.getName() + "','" + newUser.getAccountType() + "', '"
					+ newUser.getMiddleName() + "', '" + DateConverter.utilDateToSqlDate(newUser.getRegistryDate())
					+ "', '" + newUser.getSurName() + "', '" + DateConverter.utilDateToSqlDate(newUser.getBirthDate())
					+ "', '" + newUser.getPostalCode() + "', '" + newUser.getCity() + "', '" + newUser.getCountry()
					+ "', '" + newUser.getPassword() + "')";

			statement.executeUpdate(sql);

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
	}

	@Override
	public FreeAccount getByLogin(Account account) throws SQLException, Exception {

		FreeAccount ret = null;

		String sql = "select * from account where accountId = " + account.getId();

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {

				ret = new FreeAccount();

				int accountId = resultSet.getInt("accountid");
				String accountName = resultSet.getString("accountName");
				String accountType = resultSet.getString("accountType");
				String accountMiddleName = resultSet.getString("accountMiddleName");
				String accountSurName = resultSet.getString("accountSurName");
				java.sql.Date accountBirthDate = resultSet.getDate("accountBirthDate");
				int postCode = resultSet.getInt("accountPostCode");
				String accountCity = resultSet.getString("accountCity");
				String accountCountry = resultSet.getString("accountCountry");
				String password = resultSet.getString("accountPassword");

				ret.setId(accountId);
				ret.setName(accountName);
				ret.setAccountType(accountType);
				ret.setMiddleName(accountMiddleName);
				ret.setSurName(accountSurName);
				ret.setBirthDate(DateConverter.sqlDateToUtilDate(accountBirthDate));
				ret.setPostalCode(postCode);
				ret.setCity(accountCity);
				ret.setCountry(accountCountry);
				ret.setPassword(password);

			}
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
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
	public void updateLastLogin(FreeAccount t, Date currentDate) {

	}

	@Override
	public void updateIsBloqued(FreeAccount t, Boolean bloqued) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(FreeAccount t, String password) throws SQLException, Exception {

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

	@Override
	public FreeAccount getOne(FreeAccount t) {
		// TODO Auto-generated method stub
		return null;
	}

}
