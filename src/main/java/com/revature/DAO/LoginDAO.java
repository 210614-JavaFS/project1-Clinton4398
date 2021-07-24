package com.revature.DAO;

import java.util.List;

import com.revature.Models.Empee;

import Exceptions.LoginException;

public interface LoginDAO
{
	public Empee getEmpeeByLogin(String username, String password);
	public void setEmployeeLogin(Empee empee, String username, String password) throws LoginException;
	public List<String> getAllUsernames();
	public List<Integer> getAllLoginOwners();
	public void updateEmpeeLogin(Empee empee, LoginField fld, String newVal) throws LoginException;
	public void deleteEmpee(Empee empee);
}
