package com.revature.DAO;

public enum EmpeeField
{
	FNAME ("fname"),
	LNAME ("lname"),
	EMPEEROLE ("empeerole"),
	STREET ("stret"),
	CITY ("city"),
	STATE ("state"),
	ZIP ("zip"),
	PHONE ("phone"),
	EMAIL ("email");
	
	private String fld;
	
	EmpeeField(String fld)
	{
		this.fld = fld;
	}
	
	public String getFld()
	{
		return this.fld;
	}
}

