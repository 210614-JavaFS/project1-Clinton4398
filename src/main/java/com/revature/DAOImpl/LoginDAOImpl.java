package com.revature.DAOImpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import com.revature.DAO.LOGIN_DAO;
import com.revature.DAO.LoginField;
import com.revature.Models.ERS_USERS;
import com.revature.Utils.ConnectionUtil;

import Exceptions.LoginException;

public class LoginDAOImpl implements LOGIN_DAO
{
	
		//final static Logger log = Logger.getLogger(LoginDAOImpl.class);
	
		private static LoginDAOImpl logInstance;
		
		public LoginDAOImpl()
		{
			
		}
		
		
		
		public static LoginDAOImpl getLoginDAOImpl()
		{
			logInstance = logInstance == null ? new LoginDAOImpl() : logInstance;
			return logInstance;
		}
		
		// add doesusername and doespassword  methods
		@Override
		public ERS_USERS getByLogin(String ers_username, String ers_password)
		{
				try
				{
					String sql = "SELECT * FROM ers_users INNER JOIN ers_user_roles ON"
							+ " ers_users.ers_users_id = ers_user_roles.ers_user_role_id"
							+ " WHERE ers_users.ers_username = ? AND  ers_users.ers_password = ?";
				
					Connection conn = ConnectionUtil.getConn();
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, ers_username);
					ps.setString(2,  ers_password);
				
					ResultSet rs = ps.executeQuery();
				
					while(rs.next())
					{
						return new ERS_USERS(
													rs.getInt("ers_users_id"),
													rs.getString("ers_username"),
													rs.getString("ers_password"),
													rs.getString("user_first_name"),
													rs.getString("user_last_name"),
													rs.getString("user_email"),
													rs.getInt("user_role_id")
						);
					}
				}
				catch (SQLException e)
				{
					e.printStackTrace();
					//log.error(e.getMessage());
				}
				return null;
		}
		
		
		public void setUserLogin(int ers_users_id, String ers_username, String ers_password)
				throws LoginException {
				try
				{
					String sql = "CALL addLogin(?, ?, ?)";
					
					List<Integer> users = this.getAllLoginOwnerUsers();
					if(users != null && users.contains(ERS_USERS.getErs_users_id()))
					{
						throw new LoginException();
					}
					
					Connection conn = ConnectionUtil.getConn();
					CallableStatement  cs = conn.prepareCall(sql);
					cs.setInt(1, ers_users_id);
					cs.setString(2,  ers_username);
					cs.setString(3,  ers_password);
					
					cs.executeUpdate();
				}catch(SQLException e)
				{
					//log
					//log
				}
		}
		
		
		@Override
		public List<String> getAllUsernames() {
			try
			{
				String sql = "SELECT ers_username FROM ers_users";
				
				Connection conn = ConnectionUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				List<String> ers_usernames = new ArrayList<String>();
				
				while(rs.next()) {
					ers_usernames.add(rs.getString("username"));
				}
				
				return ers_usernames;
					
			} catch(SQLException e) 
			{
				//e.printStackTrace();
				//log.error(e.getMessage());
			}
			return null;
		}
		
		
		@Override
		public List<Integer> getAllLoginOwnerUsers() {
			try {
				String sql = "Select ers_username FROM login";
				
				Connection conn = ConnectionUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				List<Integer> loginOwners = new ArrayList<Integer>();
				
				while(rs.next()) {
					loginOwners.add(rs.getInt("ers_username"));
				}
				
				return loginOwners;
			} catch(SQLException e) {
				e.printStackTrace();
				//log.error(e.getMessage());
			}
			
			return null;
		}
		
		
		public void updateUserLogin(ERS_USERS ers_users, LoginField field) throws LoginException
		{
			try
			{
					if(field.equals(LoginField.ERS_USERNAME))
					{
							List<String> ers_usernames = this.getAllUsernames();
							if(ers_usernames.contains(ers_users.getErs_username()))
							{
								throw new LoginException("Username is already taken!");
							}
					}
				
				
				String sql = String.format("UPDATE ers_users WHERE ers_username = ?",
						field.getField()
				);
				
				Connection conn = ConnectionUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, ers_users.getErs_username());
				
				ps.executeUpdate();
				
			} catch(SQLException e)
			{
				e.printStackTrace();
				//log.error(e.getMessage());
			}
		}
		
		
		@Override
		public void deleteUserLogin(ERS_USERS ers_users) {
			try {
				String sql = "DELETE FROM ers_users WHERE ers_username = ?";
				
				Connection conn = ConnectionUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, ers_users.getErs_username());
				
				ps.executeUpdate();
				
			} catch(SQLException e) {
				e.printStackTrace();
				//log.error(e.getMessage());
			}
		}



		public boolean doesUsernameMatch(String ers_username) throws SQLException {
			boolean match = false;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
			
			Connection conn= ConnectionUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, ers_username);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				match = true;
			} else {
				match = false;
			}
			
			return match;
			
		}



		@Override
		public boolean doesPasswordMatch(String ers_password, String ers_username) throws SQLException {
			boolean match = false;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM ers_users WHERE ers_password = ?"
						+ " AND ers_username = ?";
			
			Connection conn= ConnectionUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ers_password);
			ps.setString(2,  ers_username);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				if ((ers_password.equals(rs.getString("password")) && ers_username.equals(rs.getString("username")))) {
					match = true;
				} else {
					match = false;
			}		
		}
			return match;
			
		}



		@Override
		public void setUserLogin(ERS_USERS ers_users_id, String ers_username, String ers_password)
				throws LoginException {
			// TODO Auto-generated method stub
			
		}
}
