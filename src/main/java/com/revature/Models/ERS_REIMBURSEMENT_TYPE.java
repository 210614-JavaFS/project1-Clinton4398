package com.revature.Models;

public enum ERS_REIMBURSEMENT_TYPE 
{
	MOVING  (1),
	PARKING  (2),
	COMMUTE  (3),
	BUSINESS  (4),
	OTHER  (5);
	
	private int reimb_type_id;
	
	ERS_REIMBURSEMENT_TYPE(int reimb_type_id)
	{
			this.reimb_type_id = reimb_type_id;
	}
	public int getReimb_type_id() {
		return this.reimb_type_id;
	}
	
	public static ERS_REIMBURSEMENT_TYPE getReimbTypeLevel(int typeLevel)
	{
		for(ERS_REIMBURSEMENT_TYPE ersReimbType: ERS_REIMBURSEMENT_TYPE.values())
		{
			if (ersReimbType.getReimb_type_id() == typeLevel) 
			{
				return ersReimbType;
			}
		}
		return null;
	}
	
	
	
}//class body close
