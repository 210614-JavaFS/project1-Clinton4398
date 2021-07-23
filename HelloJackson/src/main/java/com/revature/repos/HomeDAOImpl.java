package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class HomeDAOImpl implements HomeDAO{

	@Override
	public List<Home> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM homes";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Home> list = new ArrayList<>();
			
			//ResultSets have a cursor similarly to Scanners or other I/O classes. 
			while(result.next()) {
				Home home = new Home();
				home.setHomeName(result.getString("home_name"));
				home.setStreetAddress(result.getString("home_st_add"));
				home.setCity(result.getString("home_city"));
				home.setRegion(result.getString("home_region"));
				home.setZip(result.getString("home_zip"));
				list.add(home);
			}
			
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home findByName(String name) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM homes WHERE home_name = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//This is where SQL injection is checked for.
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			Home home = new Home();
			
			//ResultSets have a cursor similarly to Scanners or other I/O classes. 
			while(result.next()) {
				home.setHomeName(result.getString("home_name"));
				home.setStreetAddress(result.getString("home_st_add"));
				home.setCity(result.getString("home_city"));
				home.setRegion(result.getString("home_region"));
				home.setZip(result.getString("home_zip"));
			}
			
			return home;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public boolean updateHome(Home home) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHome(Home home) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO homes (home_name, home_st_add, home_city, home_region, home_zip)"
					+ " VALUES (?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, home.getHomeName());
			statement.setString(++index, home.getStreetAddress());
			statement.setString(++index, home.getCity());
			statement.setString(++index, home.getRegion());
			statement.setString(++index, home.getZip());
			
			statement.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
