package com.revature.DAO;

import java.util.List;

import com.revature.Models.Empee;
import com.revature.Models.EmpeeRole;

import Exceptions.EmpeeException;

public interface EmpeeDAO 
{
	public void createEmpee(Empee empee) throws EmpeeException;
	public List<String> getEmpeeIds();
	public Empee getEmpeeById(String empeeId);
	public Empee getEmpeeById(int uid);
	public List<Empee> getAllEmpees();
	public void updateEmpee(Empee empee, EmpeeField fld, String newVal);
	public void updateEmpee(Empee empee, EmpeeRole newRole);
	public void deleteEmpee(Empee empee);
}
