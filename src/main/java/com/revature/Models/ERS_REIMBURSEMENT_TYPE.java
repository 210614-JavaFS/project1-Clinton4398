package com.revature.Models;

public class ERS_REIMBURSEMENT_TYPE 
{
	protected int reimb_type_id;
	protected int reimb_type;
	
	
	public ERS_REIMBURSEMENT_TYPE(int reimb_type_id, int reimb_type)
	{
		super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_type = reimb_type;
	}


	public ERS_REIMBURSEMENT_TYPE() 
	{
		super();
	}


	public int getReimb_type_id() {
		return reimb_type_id;
	}


	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}


	public int getReimb_type() {
		return reimb_type;
	}


	public void setReimb_type(int reimb_type) {
		this.reimb_type = reimb_type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reimb_type;
		result = prime * result + reimb_type_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERS_REIMBURSEMENT_TYPE other = (ERS_REIMBURSEMENT_TYPE) obj;
		if (reimb_type != other.reimb_type)
			return false;
		if (reimb_type_id != other.reimb_type_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ERS_REIMBURSEMENT_TYPE [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type + "]";
	}
	
	
}//class body close
