package com.revature.DAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		
		@Override
		public void setUserLogin(ERS_USERS ers_users_id, String ers_username, String ers_password)
				throws LoginException {
				try
				{
					String sql = "INSERT INTO ers_users(ers_users_id, ers_username, ers_password, user_first_name, "
							+ "user_last_name, user_email, user_role_id) VALUES  (nextval (\'user_idSeq\'), ?. ?, ?, ?, ?,"
							+ " nextval (\'user_roleSeq\')";
				}
		}
		
		
		@Override
		public List<String> getAllUsernames() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		@Override
		public List<Integer> getAllLoginOwners() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		@Override
		public void updateUserLogin(ERS_USERS ers_users, LoginField field, String newVal) throws LoginException {
			// TODO Auto-generated method stub
			
		}
		
		
		@Override
		public void deleteUserLogin(ERS_USERS ers_users) {
			// TODO Auto-generated method stub
			
		}
}
