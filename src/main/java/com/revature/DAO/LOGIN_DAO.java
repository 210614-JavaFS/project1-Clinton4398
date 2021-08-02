package com.revature.DAO;

import java.sql.SQLException;
import java.util.List;

import com.revature.Models.ERS_USERS;

import Exceptions.LoginException;

public interface LOGIN_DAO 
{
	public ERS_USERS getByLogin(String ers_username, String ers_password);
	public void setUserLogin(ERS_USERS ers_users_id, String ers_username, String ers_password) throws LoginException;
	public List<String> getAllUsernames();
	public List<Integer> getAllLoginOwnerUsers();
	public void updateUserLogin(ERS_USERS ers_users, LoginField field) throws LoginException;
	public void deleteUserLogin(ERS_USERS ers_users);
	public boolean doesUsernameMatch(String ers_username) throws SQLException;
	public boolean doesPasswordMatch(String ers_password, String ers_username) throws SQLException;
}
