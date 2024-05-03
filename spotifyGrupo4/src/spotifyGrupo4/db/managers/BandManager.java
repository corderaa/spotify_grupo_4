package spotifyGrupo4.db.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spotifyGrupo4.db.pojo.Band;
import spotifyGrupo4.db.utils.DBUtils;
import spotifyGrupo4.utils.DateConverter;

public class BandManager implements ContentInterface<Band>, InterfaceManager<Band> {
private String GET_ALL_BANDS= "select * from band b join contentcreator c using (contentCreatorId)";
	@Override
	public List<Band> getAll() {
		ArrayList<Band> ret = null;

		String sql = GET_ALL_BANDS;

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
					ret = new ArrayList<Band>();

				spotifyGrupo4.db.pojo.Band band = new spotifyGrupo4.db.pojo.Band();

				int contentCreatorId = resultSet.getInt("contentCreatorId");
				int members = resultSet.getInt("members");
				String contentCreatorName = resultSet.getString("contentCreatorName");
				java.sql.Date creationDate = resultSet.getDate("creationDate");
				int numberReproductions = resultSet.getInt("numberReproductions");
				String contentCreatorDescription = resultSet.getString("contentCreatorDescription");
				String contentCreatorImage = resultSet.getString("contentCreatorImage");

				band.setId(contentCreatorId);
				band.setMembers(members);
				band.setName(contentCreatorName);
				band.setReproduction(numberReproductions);
				band.setCreationDate(DateConverter.sqlDateToUtilDate(creationDate));
				band.setReproduction(numberReproductions);
				band.setDescription(contentCreatorDescription);
				band.setImage(contentCreatorImage);

				
				ret.add(band);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
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
		return ret;
	}


	@Override
	public void insert(Band t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Band t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Band t) {
		// TODO Auto-generated method stub

	}
}
