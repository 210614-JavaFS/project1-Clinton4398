package com.revature.DAO;

import java.util.List;

import com.revature.Models.ERS_USERS;
import com.revature.Models.ERS_USER_ROLES;

public interface ERS_USERS_DAO 
{
	
	public void createUser(ERS_USERS ers_users);
	public List<String> getUsersId();
	public ERS_USERS getUsersById(int ers_users_id );
	public ERS_USERS getUsersById(String ers_username);
	public List<ERS_USERS> getAllUsers();
	public void updateUsers(ERS_USERS ers_users, EmpeeField field, String newVal);
	public void updateUsers(ERS_USERS ers_users, ERS_USER_ROLES ers_user_role_id);
	public void deleteusers(ERS_USERS ers_users);
	

}
