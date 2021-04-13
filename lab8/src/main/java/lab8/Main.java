package lab8;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Conexiune test = Conexiune.getInstance();// am facut singleton si am luat instanta
		Statement s = null;
		ResultSet r = null; // avem nevoie de ele pt a rula query
		try {
			s = test.createStatement();
			r = s.executeQuery("Select * from movies");
			// afisez rezultatele
			ResultSetMetaData rsmd = r.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (r.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = r.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (SQLException e) {

				}
			}

			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {

				}
			}
		}
	}

}
