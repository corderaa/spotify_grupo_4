package spotifyGrupo4.utils;

import java.util.Date;

public class DateConverter {

	/**
	 * Takes a sql.Date and transforms it into a util.Date
	 * 
	 * @param sqlDate
	 * @return
	 */
	public static java.util.Date sqlDateToUtilDate(java.sql.Date sqlDate) {
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
}

	/**
	 * Takes a util.Date and transforms it into a sql.Date
	 * 
	 * @param Date
	 * @return
	 */
	public static java.sql.Date utilDateToSqlDate(java.util.Date date) {
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
}
