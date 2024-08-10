package CRUDApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class Databaseutility {
	static Connection conn = null, con;
	public static Connection connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "test_db";
			String name = System.getenv("DB_USER");
			String password = System.getenv("DB_PASSWORD");
			
			conn = DriverManager.getConnection(url+db, name, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
