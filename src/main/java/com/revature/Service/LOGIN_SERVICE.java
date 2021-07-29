package com.revature.Service;

import org.slf4j.Logger;

import com.revature.DAOImpl.LoginDAOImpl;


public class LOGIN_SERVICE {
		//final static Logger log = Logger.getLogger(LOGIN_SERVICE.class);
	
		private static LOGIN_SERVICE instance;
		private LoginDAOImpl LDI;
		
		private LOGIN_SERVICE()
		{
				this.LDI = LoginDAOImpl.getLoginDAOImpl();
		}
}
