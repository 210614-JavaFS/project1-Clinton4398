package com.revature.DAO;

import java.util.List;

import com.revature.Models.ERS_REIMBURSEMENT;
import com.revature.Models.ERS_REIMBURSEMENT_STATUS;
import com.revature.Models.ERS_REIMBURSEMENT_TYPE;
import com.revature.Models.ERS_USERS;

public interface ERS_REIMB_DAO
{
	public void submitReimb(ERS_REIMBURSEMENT ers_reimbursement);
	public ERS_REIMBURSEMENT getReimb(ERS_USERS ers_users, ERS_REIMBURSEMENT ers_reimbursement);
	public List<ERS_REIMBURSEMENT> getAllSubmitterReimb(ERS_USERS ers_users);
	public List<ERS_REIMBURSEMENT> getAllExpenses();
	public void resolveReimb(int reimb_id, ERS_REIMBURSEMENT_STATUS ers_reimb_status, String reimb_resolver);
	public void deleteReimb(ERS_REIMBURSEMENT ers_reimbursement);
	public void getAllDeletedReimb(ERS_REIMBURSEMENT ers_reimbursement, boolean bool);
}
