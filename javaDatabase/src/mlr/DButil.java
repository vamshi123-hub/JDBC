package mlr;

import java.sql.Connection;

import java.sql.DriverManager;

public class DButil {

	public static Connection getDBConnection() {
		Connection conn = null;
		try {
		
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mlr","root","rsv@0202");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
