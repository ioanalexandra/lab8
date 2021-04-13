package lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiune {
	private Connection c = null;
	private static Conexiune conex = null;

	private Conexiune() {
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost/lab8?" + "user=root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Conexiune getInstance() {
		if (conex == null) {
			conex = new Conexiune();
		}
		return conex;
	}
}
