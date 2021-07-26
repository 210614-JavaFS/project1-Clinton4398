package com.revature.DAO;

import java.util.List;

import com.revature.Models.ERS_REIMBURSEMENT_TYPE;

public interface ERS_TYPE_DAO 
{
	List<ERS_REIMBURSEMENT_TYPE> findall();
	List<ERS_REIMBURSEMENT_TYPE> findByType();
	List<ERS_REIMBURSEMENT_TYPE> findByTypeId();
	boolean insertReimbType(ERS_REIMBURSEMENT_TYPE ers_reimb_type);
	boolean updateReimbType(ERS_REIMBURSEMENT_TYPE ers_reimb_type);
	boolean deleteReimbType(ERS_REIMBURSEMENT_TYPE ers_reimb_type);
	
}
