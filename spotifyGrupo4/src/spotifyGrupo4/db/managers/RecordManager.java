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

public class RecordManager
		implements ContentInterface<spotifyGrupo4.db.pojo.Record>, InterfaceManager<spotifyGrupo4.db.pojo.Record> {

	@Override
	public List<spotifyGrupo4.db.pojo.Record> getAll() {
		return null;
	}

	public List<spotifyGrupo4.db.pojo.Record> getAllWithBand() {
		ArrayList<spotifyGrupo4.db.pojo.Record> ret = null;

		// SQL que queremos lanzar
		String sql = "select * from record as r join band as b on r.bandId = b.contentCreatorId ";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new <spotifyGrupo4.db.pojo.Record>ArrayList();

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
				record.setReleaseDate(null);
				record.setTitle(title);
				record.setNumberReproductions(numberReproductions);

				Band band = new Band();

				int bandId = resultSet.getInt("contentCreatorId");
				int members = resultSet.getInt("members");
				String contentCreatorName = resultSet.getString("contentCreatorName");
				int contentCreatorReproductions = resultSet.getInt("contentCreatorReproductionNumber");
				java.sql.Date contentCreatorRegistrationDate = resultSet.getDate("contentCreatorRegistrationDate");
				String contentCreatorDescription = resultSet.getString("contentCreatorDescription");

				band.setId(bandId);
				band.setContentCreatorId(bandId);
				band.setMembers(members);
				band.setCreationDate(contentCreatorRegistrationDate);
				band.setDescription(contentCreatorDescription);
				band.setImage(null);
				band.setName(contentCreatorName);
				band.setReproduction(contentCreatorReproductions);

				record.setBand(band);
				ret.add(record);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}

	@Override
	public void insert(spotifyGrupo4.db.pojo.Record t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(spotifyGrupo4.db.pojo.Record t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(spotifyGrupo4.db.pojo.Record t) {
		// TODO Auto-generated method stub

	}

}
