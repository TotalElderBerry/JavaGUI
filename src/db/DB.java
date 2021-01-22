package db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class DB {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem_db?useSSL=false","root","root");
		return con;
	}
	
}
