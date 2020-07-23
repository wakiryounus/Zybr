package k.wakir;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionProvider implements DbProvider {
	static Connection con = null;
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(connectionUrl, username, password);
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
