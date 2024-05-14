package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.pojo.Record;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

public class RecordManager implements ContentInterface<Record>, InterfaceManager<Record> {
	private static final String GET_ONE_RECORD = null;
	private String GET_ALL_RECORDS = "select * from record as r join band as b on r.bandId = b.contentCreatorId ";

	@Override
	public List<Record> getAll() {
		return null;
	}

	public List<Record> getAllWithBand() throws SQLException, Exception {
		ArrayList<Record> ret = null;

		String sql = "select * from record as r join band as b on r.bandId = b.contentCreatorId join contentcreator as c on b.contentCreatorId = c.contentCreatorId ";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Record>();

				spotifyGrupo4.db.pojo.Record record = new spotifyGrupo4.db.pojo.Record();

				int recordId = resultSet.getInt("recordId");
				String title = resultSet.getString("title");
				String cover = resultSet.getString("cover");
				String genre = resultSet.getString("genre");
				java.sql.Date releaseDate = resultSet.getDate("releaseDate");
				int numberReproductions = resultSet.getInt("numberReproductions");

				record.setId(recordId);
				record.setGenre(genre);
				record.setRecordCover(cover);
				record.setReleaseDate(DateConverter.sqlDateToUtilDate(releaseDate));
				record.setTitle(title);
				record.setNumberReproductions(numberReproductions);

				Band band = new Band();

				int bandId = resultSet.getInt("contentCreatorId");
				int members = resultSet.getInt("members");
				String contentCreatorName = resultSet.getString("contentCreatorName");
				int contentCreatorReproductions = resultSet.getInt("contentCreatorReproductionNumber");
				java.sql.Date contentCreatorRegistrationDate = resultSet.getDate("contentCreatorRegistrationDate");
				String contentCreatorDescription = resultSet.getString("contentCreatorDescription");
				String bandImage = resultSet.getString("contentCreatorImage");

				band.setId(bandId);
				band.setContentCreatorId(bandId);
				band.setMembers(members);
				band.setCreationDate(DateConverter.sqlDateToUtilDate(contentCreatorRegistrationDate));
				band.setDescription(contentCreatorDescription);
				band.setImage(bandImage);
				band.setName(contentCreatorName);
				band.setReproduction(contentCreatorReproductions);

				record.setBand(band);
				ret.add(record);
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
	public void insert(Record t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Record t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Record t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Record getOne(Record bandId) {
		Record record = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = GET_ONE_RECORD;
			statement = connection.prepareStatement(sql);
			statement.setObject(1, bandId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				record = new Record();
				record.setId(resultSet.getInt("recordId"));
				record.setTitle(resultSet.getString("title"));
				record.setRecordCover(resultSet.getString("recordCover"));
				record.setGenre(resultSet.getString("genre"));
				record.setReleaseDate(resultSet.getDate("realeseDate"));
				
				record.setNumberReproductions(resultSet.getInt("numberReproduction"));
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return record;
	}
}
