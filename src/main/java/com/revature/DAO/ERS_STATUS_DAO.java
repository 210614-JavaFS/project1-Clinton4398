package com.revature.DAO;

import java.util.List;

import com.revature.Models.ERS_REIMBURSEMENT_STATUS;

public interface ERS_STATUS_DAO
{
	
	List<ERS_REIMBURSEMENT_STATUS> findAllReimbStatus();
	ERS_REIMBURSEMENT_STATUS findReimbStatusById(int reimb_status_id);
	boolean updateReimbStatus(ERS_REIMBURSEMENT_STATUS reimb_status);
	boolean addStatus(ERS_REIMBURSEMENT_STATUS reimb_status);
	String addReimbStatusId(ERS_REIMBURSEMENT_STATUS reimb_status_id);
}
