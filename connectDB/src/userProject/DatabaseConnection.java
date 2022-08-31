package userProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {

	// connect java with MYsql database
	protected static Connection initializeDatabase() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // register mysql driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectlogin", "root", "root");
			System.out.println("Connected successfully in retrieve");


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;

	}

	
}
