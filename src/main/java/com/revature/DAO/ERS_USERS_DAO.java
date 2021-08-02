package com.revature.DAO;

import java.util.List;

import com.revature.Models.ERS_USERS;
import com.revature.Models.ERS_USER_ROLES;

import Exceptions.ErsUserException;

public interface ERS_USERS_DAO 
{
	
	public void createUser(ERS_USERS ers_users) throws ErsUserException;
	public List<String> getUsersId();
	public ERS_USERS getUsersById(int ers_users_id );
	public ERS_USERS getUsersByIdAndName(int ers_users_id, String ers_first_name, String ers_last_name);
	public List<ERS_USERS> getAllUsers();
	public void updateUsers(ERS_USERS ers_users, ErsUserField field);
	public void updateUsers(String ers_users, int ers_user_role_id);
	public void deleteusers(String ers_users);
	

}
