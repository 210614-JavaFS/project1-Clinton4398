package com.revature.Models;

public enum ERS_USER_ROLES 
{
		MANAGER  (1),
		EMPLOYEE  (2);
	

	private int ers_user_roles_id;
	
	ERS_USER_ROLES(int ers_user_roles_id) {
			this.ers_user_roles_id = ers_user_roles_id;
		}
	
	public int getErs_user_roles_id() {
		return this.ers_user_roles_id;
	}
	
	public static ERS_USER_ROLES getErs_user_roles_idLevel(int level)
	{
		for(ERS_USER_ROLES ersUserRoles: ERS_USER_ROLES.values())
		{
			if(ersUserRoles.getErs_user_roles_id() == level)
			{
				return ersUserRoles;
			}
		}
		return null;
	}
}
	
	
		

