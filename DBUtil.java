package pms.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getDBConnection() {
		Connection conn = null;
		
		try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		conn = DriverManager.getConnection("http://localhost/phpmyadmin/index.php?route=/database/structure&db=kishore", "localhost", "root");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
	
	
	public static void  closeConncetion() {
		
		Connection conn =	getDBConnection();
		
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
