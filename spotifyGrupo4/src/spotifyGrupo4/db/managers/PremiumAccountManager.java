package spotifyGrupo4.db.managers;

import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import spotifyGrupo4.db.pojo.Account;
import spotifyGrupo4.db.pojo.FreeAccount;
import spotifyGrupo4.db.pojo.PremiumAccount;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

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
	public PremiumAccount getByLogin(Account account) throws SQLException, Exception {
		PremiumAccount ret = null;

		String sql = "select * from account as a join premium as p using (accountId)  where accountId = "
				+ account.getId();

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {

				ret = new PremiumAccount();

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
				long cardNumber = resultSet.getLong("cardNumber");
				int cvv = resultSet.getInt("cvv");
				java.sql.Date expiringDate = resultSet.getDate("expiringDate");

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
				ret.setExpiringDate(DateConverter.sqlDateToUtilDate(expiringDate));
				ret.setCardCvv(cvv);
				ret.setCardNumber(cardNumber);

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
	public void updateLastLogin(PremiumAccount t, Date currentDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateIsBloqued(PremiumAccount t, Boolean bloqued) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(PremiumAccount t, String password) throws SQLException, Exception {
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
	public PremiumAccount getOne(PremiumAccount t) {
		// TODO Auto-generated method stub
		return null;
	}

}
