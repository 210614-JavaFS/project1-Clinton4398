package com.revature.DAO;

import java.util.List;

import com.revature.Models.ERS_USERS;

import Exceptions.LoginException;

public interface LOGIN_DAO 
{
	public ERS_USERS getByLogin(String ers_username, String ers_password);
	public void setUserLogin(ERS_USERS ers_users_id, String ers_username, String ers_password) throws LoginException;
	public List<String> getAllUsernames();
	public List<Integer> getAllLoginOwners();
	public void updateUserLogin(ERS_USERS ers_users, LoginField field, String newVal) throws LoginException;
	public void deleteUserLogin(ERS_USERS ers_users);
	public void doesUsernameMatch(String ers_username);
	public void doesPasswordMatch(String ers_password, String ers_username);
}
