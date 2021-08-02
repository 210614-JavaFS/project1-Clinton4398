package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.ERS_USERS_DAO;
import com.revature.DAO.ErsUserField;
import com.revature.Models.ERS_USERS;
import com.revature.Models.ERS_USER_ROLES;
import com.revature.Utils.ConnectionUtil;

import Exceptions.ErsUserException;

public class ERS_USERS_DAOImpl implements ERS_USERS_DAO {
		//final static Logger log = Logger.getLogger(ERS_USERS_DAOImpl.class);
	
	private static ERS_USERS_DAOImpl instance;
	
	private ERS_USERS_DAOImpl()
	{
	
	}

	public static ERS_USERS_DAOImpl getERS_USERS_DAOImpl() {
			instance = instance == null ? new ERS_USERS_DAOImpl() : instance;
			return instance;
	}

	@Override
	public void createUser(ERS_USERS ers_users) throws ErsUserException 
	{
			try
			{
				String sql = "CALL addErsUsers(?, ?, ?, ?, ?, ?, ?)";
				
				List<String> userIds = this.getUsersId();
				if(userIds.contains(ERS_USERS.getErs_users_id())) {
					throw new ErsUserException();
				}
				Connection conn = ConnectionUtil.getConn();
				if(conn == null) {
					//log.warn("Problem connecting to Database/AWS");
					return;
				}
				CallableStatement cs = conn.prepareCall(sql);
				
				int i = 0;
				cs.setInt(++i, ERS_USERS.getErs_users_id() );
				cs.setString(++i, ERS_USERS.getErs_username());
				cs.setString(++i, ERS_USERS.getErs_password());
				cs.setString(++i, ERS_USERS.getUser_first_name());
				cs.setString(++i, ERS_USERS.getUser_last_name());
				cs.setString(++i, ERS_USERS.getUser_email());
				cs.setInt(++i,ERS_USERS.getUser_role_id());
				
				cs.executeUpdate();
		} catch(SQLException e)
			{
				e.printStackTrace();
				//log.error(e.getCause());
				//log.error(e.g;
			}
	}

	@Override
	public List<String> getUsersId()
	{
		List<ERS_USERS> ersUsers = this.getAllUsers();
		if(ersUsers == null)
		{
			//log.warn("no user, check connection);
			return null;
		}
		List<String> userIds = new ArrayList<String>();
		
		for(ERS_USERS user: ersUsers)
		{
			userIds.add(Integer.toString((user.getErs_users_id())));
		}
		return userIds;
		
	}

	@Override
	public ERS_USERS getUsersById(int id) 
	{
		try
		{
			String sql = String.format("SELECT * FROM ERS_USERS WHERE ers_users_id = ?");
			
			Connection conn = ConnectionUtil.getConn();
			if(conn == null) {
				//log.warn("Problem connecting to Database/AWS");
				return null;
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
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
											rs.getInt("user_roles_id")
						);
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
			//log.error(e.getCause());
			//log.error(getMessage());
		}
		return null;
	}

	public ERS_USERS getUsersByIdAndName(int ers_users_id, String ers_first_name, String ers_last_name) 
	{
		try
		{
			String sql = String.format("SELECT * FROM ers_users WHERE ers_users_id = ? AND ers_first_name = ? AND ers_last_name = ? ");
			
			Connection conn = ConnectionUtil.getConn();
			if(conn == null)
			{
				//log.warn=("problem connecting to database");
				return null;
			}
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, ers_users_id);
			ps.setString(2,  ers_first_name);
			ps.setString(3,  ers_last_name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
					return  new ERS_USERS (
													rs.getInt("ers_users_id"),
													rs.getString("ers_username"),
													rs.getString("ers_password"),
													rs.getString("user_first_name"),
													rs.getString("user_last_name"),
													rs.getString("user_email"),
													rs.getInt("user_roles_id")
							);
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ERS_USERS> getAllUsers() {
		try 
		{
				String sql = "SELECT * FROM ers_users";
				
				Connection conn = ConnectionUtil.getConn();
				if(conn == null)
				{
						//log.warn("Problem connection to database");
				}
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				List<ERS_USERS> ers_users = new ArrayList<ERS_USERS>();
				
				while(rs.next())
				{
					ers_users.add(new ERS_USERS(
										rs.getInt("ers_users_id"),
										rs.getString("ers_username"),
										rs.getString("ers_password"),
										rs.getString("user_first_name"),
										rs.getString("user_last_name"),
										rs.getString("user_email"),
										rs.getInt("user_roles_id")
							));
				}
		} catch(SQLException e)
		{
			e.printStackTrace();
			//log.warn
			//log.warn
		}
		return null;
	}

	@Override
	public void updateUsers(ERS_USERS ers_users, ErsUserField field)
	{
			try 
			{
					String sql = String.format("UPDATE ers_users WHERE ers_users_id = ?", 
							field.getField()
			);
			
			Connection conn = ConnectionUtil.getConn();
			if(conn == null) {
				//log.warn("Problem connectiong to database");
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ERS_USERS.getErs_users_id());
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			//log.error(e.getCause());
			//log.error(e.getMessage());
		}
		
	}

	@Override
	public void updateUsers(String ers_users, int ers_user_role_id) {
		try {
					String sql = "UPDATE ers_users WHERE ers_users = ? AND ers_user_role_id";
					
					Connection conn = ConnectionUtil.getConn();
					if(conn == null) {
						//log.warn("Problem connectiong to Oracle");
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ers_users);
			ps.setInt(2, ers_user_role_id);
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			//log.error(e.getCause());
			//log.error(e.getMessage());
		}
		
	}

	public void deleteusers(String ers_users)
	{
		try {
			String sql = "DELETE ers_users WHERE ers_users_id = ?"; 
			
			Connection conn = ConnectionUtil.getConn();
			if(conn == null) {
				//log.warn("Problem connectiong to Oracle");
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ers_users);
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			//log.error(e.getCause());
			//log.error(e.getMessage());
		}
	}
}