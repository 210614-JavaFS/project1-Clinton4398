package com.revature.DAO;

import java.util.List;

import com.revature.Models.ERS_USER_ROLES;

public interface ERS_USER_ROLE_DAO
{
	List<ERS_USER_ROLES> getAll();
	void updateUserRoleId(ERS_USER_ROLES userRoleId);
	void deleteUserRoleId(ERS_USER_ROLES userRoleId);
}
