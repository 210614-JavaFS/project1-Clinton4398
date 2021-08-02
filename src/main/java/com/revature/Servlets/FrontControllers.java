package com.revature.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Service.ERS_REIMB_SERVICE;
import com.revature.Service.ERS_USERS_SERVICE;
import com.revature.Service.LOGIN_SERVICE;
import com.revature.Utils.ConnectionUtil;

/**
 * Servlet implementation class FrontControllers
 */
public class FrontControllers extends HttpServlet
{
	//	final static Logger log = Logger.getLogger(FrontController.class);

	private static final long serialVersionUID = 1L;
	
	private static LOGIN_SERVICE loginService;
	private static ERS_USERS_SERVICE ersUsersService;
	private static ERS_REIMB_SERVICE ersReimbService;
	
	private static HttpSession httpsess;
       
    public FrontControllers() 
    {
        super();
    }
    

	public void init(ServletConfig servConfig) throws ServletException
	{
			//log.info("FrontController Init");
			loginService = LOGIN_SERVICE.getLoginService(); //need to complete this method
			ersUsersService = ERS_USERS_SERVICE.getErsUsersService(); //need to complete this method
			ersReimbService = ERS_REIMB_SERVICE.getErsReimbService(); //need to complete this method
	}
	
	public void destroy()
	{
			//log.info("FrontController Destroy");
			try
			{
					ConnectionUtil.getConn().close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				//log.error(e.getMessage());
			}
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String URI = request.getRequestURI();
			System.out.println(URI);
			
			//responses  come with method to create a print writer to write the body of the response.
			PrintWriter pw = response.getWriter();
			pw.print("<h1>Hello from your doGet method.</h1>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
