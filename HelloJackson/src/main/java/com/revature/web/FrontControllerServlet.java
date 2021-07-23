package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AvengerController;
import com.revature.controllers.HomeController;

public class FrontControllerServlet extends HttpServlet {

	private AvengerController avengerController = new AvengerController();
	private HomeController homeController = new HomeController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		response.setStatus(404); // Overrides Tomcat's 200 default for malformed requests.

		final String URL = request.getRequestURI().replace("/HelloJackson/", ""); // strips out base URL info.

		System.out.println(URL);

		String[] UrlSections = URL.split("/");

		switch (UrlSections[0]) {
		case "avenger":
			avengerController.getAllAvengers(response);
			break;
		case "home":
			if (UrlSections.length == 1) {
				if(request.getMethod().equals("GET")) {
					homeController.getAllHomes(response);
				}else if(request.getMethod().equals("POST")){
					homeController.addHome(request, response);
				}
			}else if(UrlSections.length == 2) {
				//URL is home/{homeName} so UrlSections[1] = homeName
				homeController.getOneHome(response, UrlSections[1].toLowerCase());
			}
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}

}
