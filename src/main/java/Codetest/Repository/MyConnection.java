package Codetest.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ codetest","root","pizza4428");
			System.out.println("Connection Success");
		} catch (Exception e) {
			System.out.println("Connection has Error : " +e.getMessage());
		}
		return con;
	}
}
