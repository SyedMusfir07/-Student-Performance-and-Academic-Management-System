package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL="jdbc:mysql://localhost:3306/edutrackpro";
	private static final String USER="root";
	private static final String PASSWORD="";
	
	public static Connection getConnection() {
		
		Connection connection=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  //driver register /load seiyum murai
			connection=DriverManager.getConnection(URL,USER,PASSWORD);
			
			if(connection !=null){
				System.out.println("Connected to the database!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}

