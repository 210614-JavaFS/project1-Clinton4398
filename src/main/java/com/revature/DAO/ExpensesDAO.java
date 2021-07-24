package com.revature.DAO;

import java.util.List;

import com.revature.Models.Empee;
import com.revature.Models.Expenses;
import com.revature.Models.ReimbStatus;

public interface ExpensesDAO 
{
	public void submitExpense(Expenses expense);
	public Expenses getExpenses(Empee empee, Expenses expense);
	public List<Expenses> getAllRequestorExpenses(Empee empee);
	public List<Expenses> getAllExpenses();
	public void resolveExpense(int eid, ReimbStatus approval, String approvingManager);
	public void deleteExpense(Expenses expense);

}
