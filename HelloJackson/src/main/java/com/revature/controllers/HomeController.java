package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Home;
import com.revature.services.HomeService;

public class HomeController {
	
	private static HomeService homeService = new HomeService();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public void getAllHomes(HttpServletResponse response) throws IOException {
		List<Home> list = homeService.getAllHomes();
		
		String json = objectMapper.writeValueAsString(list);
		response.getWriter().print(json);
		response.setStatus(200);
	}

	public void getOneHome(HttpServletResponse response, String name) throws IOException {
		Home home = homeService.getHome(name.replace("%20", " "));
		String json = objectMapper.writeValueAsString(home);
		response.getWriter().print(json);
		response.setStatus(200);
	}
	
	public void addHome(HttpServletRequest request, HttpServletResponse response) throws IOException{
		BufferedReader reader = request.getReader();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine();
		}
		
		String body = new String(stringBuilder);
		
		//NOTE: in order for this to work, your JSON object's field names must match exactly your 
		//Java object fields. 
		Home home = objectMapper.readValue(body, Home.class);
		
		if(homeService.addHome(home)) {
			response.setStatus(201);
		}else {
			response.setStatus(406);
		}
		
		
	}

}
