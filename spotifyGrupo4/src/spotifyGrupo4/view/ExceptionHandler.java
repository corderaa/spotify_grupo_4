package spotifyGrupo4.view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ExceptionHandler {

	public static void handleSqlException(SQLException sqle, String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void handleGenericException(Exception e, String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void handleIndexOutOfBoundsException(IndexOutOfBoundsException outOfBound, String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
