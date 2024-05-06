package spotifyGrupo4.utils;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ExceptionHandler {

	public static void handleSqlException(SQLException sqle, String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void handleGenericException(Exception e, String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
