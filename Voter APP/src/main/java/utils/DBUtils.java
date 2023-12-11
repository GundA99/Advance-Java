package utils;

import java.sql.*;

public class DBUtils {
	private static Connection connection;

	public static Connection openConnection(String url,String username,String pass) throws SQLException {
		// Class.forName("com.mysql.cj.jdbc.Driver")
		// DB contacting URL
		// protocol : jdbc , sub protocol : db server , server specific details
		connection = DriverManager.getConnection(url, username, pass);
		return connection;
	}
	public static void closeConnection() throws SQLException{
		if(connection != null)
			connection.close();
	}
	public static Connection getConnection()
	{
		return connection;
	}
}
