package com.revature.services;

import java.util.List;

import com.revature.models.Avenger;
import com.revature.repos.AvengerDAO;
import com.revature.repos.AvengerDAOImpl;

public class AvengerService {
	
	private static AvengerDAO avengerDao = new AvengerDAOImpl();
	
	public List<Avenger> avengersAssemble(){
		return avengerDao.findAll();
	}

}
