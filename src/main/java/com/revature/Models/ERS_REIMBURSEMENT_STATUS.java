package com.revature.Models;

public enum ERS_REIMBURSEMENT_STATUS 
{
		APPROVED  (1),
		PENDING  (2),
		DENIED  (3);
	
	

	private int reimb_status_id;
	
	ERS_REIMBURSEMENT_STATUS(int reimb_status_id)
	{
			this.reimb_status_id = reimb_status_id;
	}
	
		public int getReimb_status_id() 
		{
			return this.reimb_status_id;
		}

		public static ERS_REIMBURSEMENT_STATUS getReimb_status_idLevel(int level)
		{
			for (ERS_REIMBURSEMENT_STATUS  ErsStatus: ERS_REIMBURSEMENT_STATUS.values())
			{
				if (ErsStatus.getReimb_status_id() == level) 
				{
					return ErsStatus;
				}
				
			}
			return null;
		}
}
