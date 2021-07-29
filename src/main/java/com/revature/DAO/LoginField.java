package com.revature.DAO;

public enum LoginField {
	ERS_USERNAME ("ers_username"),
	ERS_PASSWORD ("ers_password");
	
	private String field;
	
	LoginField(String field) {
		this.field = field;
	}
	
	public String getField() {
		return this.field;
	}
}
