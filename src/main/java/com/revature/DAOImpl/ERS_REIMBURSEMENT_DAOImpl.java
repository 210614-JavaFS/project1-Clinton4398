package com.revature.DAOImpl;

import java.util.List;

import com.revature.DAO.ERS_REIMB_DAO;
import com.revature.Models.ERS_REIMBURSEMENT;
import com.revature.Models.ERS_REIMBURSEMENT_STATUS;
import com.revature.Models.ERS_USERS;

public class ERS_REIMBURSEMENT_DAOImpl  implements ERS_REIMB_DAO
	{

	@Override
	public void submitReimb(ERS_REIMBURSEMENT ers_reimbursement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ERS_REIMBURSEMENT getReimb(ERS_USERS ers_users, ERS_REIMBURSEMENT ers_reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ERS_REIMBURSEMENT> getAllSubmitterReimb(ERS_USERS ers_users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ERS_REIMBURSEMENT> getAllExpenses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resolveReimb(int reimb_id, ERS_REIMBURSEMENT_STATUS ers_reimb_status, String reimb_resolver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReimb(ERS_REIMBURSEMENT ers_reimbursement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllDeletedReimb(ERS_REIMBURSEMENT ers_reimbursement, boolean bool) {
		// TODO Auto-generated method stub
		
	}

}
