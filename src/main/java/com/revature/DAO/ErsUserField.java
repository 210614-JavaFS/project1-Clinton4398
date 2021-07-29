package com.revature.DAO;

public enum ErsUserField
{
		ERS_USERS_ID("ers_users_id"),
		ERS_USERNAME("ers_username"),
		ERS_PASSWORD("ers_password"),
		USER_FIRST_NAME("user_first_name"),
		USER_LAST_NAME("user_last_name"),
		USER_EMAIL("user_email"),
		USER_ROLE_ID("user_role_id");
		
		private String field;
		
		ErsUserField(String field)
		{
			this.field = field;
		}
		
		public String getField() {
			return this.field;
		}
	
}
