package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoadSections {
	DataBaseConnection myConnection;
	Measures measure;
	
	public LoadSections() {
		
		myConnection = new DataBaseConnection();
		
	}
	
	public boolean create (Measures measure) {

		
		PreparedStatement myStatament= null;
		
		Connection accessBBDD = myConnection.getConnection();
		
		String sql = "INSERT INTO measures (temperature, times, date_time) VALUES (?,?,?)";
			
		try {  
			
			myStatament = accessBBDD.prepareStatement(sql);
			myStatament.setDouble(1, measure.getTemperature());
			myStatament.setDouble(2, measure.getTimes()); 
			myStatament.setTimestamp(3, Timestamp.valueOf(measure.getDate_time()));
			myStatament.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			return false;
		} finally {
			
			try {
				accessBBDD.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public boolean update (Measures measure) {
			
		PreparedStatement myStatament= null;
		
		Connection accessBBDD = myConnection.getConnection();
		
		String sql = "UPDATE measures SET temperature=?, times=?, date_time=? WHERE id=?";
			
		try {  
			
			myStatament = accessBBDD.prepareStatement(sql);
			myStatament.setDouble(1, measure.getTemperature());
			myStatament.setDouble(2, measure.getTimes());
			myStatament.setTimestamp(3, Timestamp.valueOf(measure.getDate_time()));
			myStatament.setInt(4, measure.getId());
			myStatament.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			return false;
		} finally {
			
			try {
				accessBBDD.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}
	
	public boolean delate () {
		
		Statement myStatament= null;
		
		Connection accessBBDD = myConnection.getConnection();
		
		String sql = "DELETE FROM measures";
		String resetIdSql = "ALTER TABLE measures AUTO_INCREMENT = 1";
			
		try {  
			
			myStatament = accessBBDD.createStatement();
			myStatament.execute(sql);
			
			myStatament.execute(resetIdSql);
			
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			return false;
		} finally {
			
			try {
				accessBBDD.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}

	public ObservableList<Measures> read() {
		
		ObservableList<Measures> list = FXCollections.observableArrayList();
		
		Statement myStatament= null;
		ResultSet resultSet = null;
		
		Connection accessBBDD = myConnection.getConnection();
		
		String sql = "SELECT * FROM measures ORDER BY date_time DESC ";
			
		try {  
			
			myStatament = accessBBDD.createStatement();
			resultSet = myStatament.executeQuery(sql);
			
			while(resultSet.next()) {
				
				//measure.setTemperature(resultSet.getString("temperature"));
				//measure.setTimes(resultSet.getString("times"));
				//measure.setDate_time(resultSet.getDate("date_time"));
				
				Double temperature = Double.parseDouble(resultSet.getString("temperature"));
				Double time = Double.parseDouble(resultSet.getString("times"));
				Timestamp timestamp = resultSet.getTimestamp("date_time");
				LocalDateTime date_time = timestamp.toLocalDateTime();
				
				Measures measure = new Measures(temperature, time, date_time);
				
				list.add(measure);
				
				//return true;
			}
			
			//return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			//return false;
		} finally {
			
			try {
				accessBBDD.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
			
	}
}
