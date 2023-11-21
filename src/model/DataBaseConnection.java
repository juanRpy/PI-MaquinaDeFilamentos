package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
Connection myConnection = null;
	
	public DataBaseConnection(){
		
	}
	
	public Connection getConnection() {
		
		    try {
		        myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3305/filamentmachine_db", "root", "7492");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return myConnection;
		}
		
}
