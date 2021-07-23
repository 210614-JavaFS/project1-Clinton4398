package com.revature.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Avenger;
import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class AvengerDAOImpl implements AvengerDAO {
	
	private static HomeDAO homeDao = new HomeDAOImpl();

	@Override
	public List<Avenger> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM avengers";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Avenger> list = new ArrayList<>();
			
			//ResultSets have a cursor similarly to Scanners or other I/O classes. 
			while(result.next()) {
				Avenger avenger = new Avenger();
				avenger.setSuperheroId(result.getInt("superhero_id"));
				avenger.setSuperheroName(result.getString("superhero_name"));
				avenger.setSuperheroPower(result.getString("superhero_power"));
				avenger.setFirstName(result.getString("first_name"));
				avenger.setLastName(result.getString("last_name"));
				avenger.setPowerLevel(result.getInt("power_level"));
				String homeName = result.getString("home");
				if(homeName!=null) {
					Home home = homeDao.findByName(homeName);
					avenger.setHome(home);
				}
				list.add(avenger);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Avenger findAvenger(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAvenger(Avenger avenger) {
		// TODO Auto-generated method stub
		return false;
	}

}
