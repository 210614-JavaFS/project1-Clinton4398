package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Avenger;
import com.revature.services.AvengerService;

public class AvengerController {
	
	private static AvengerService avengerService = new AvengerService();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public void getAllAvengers(HttpServletResponse response) throws IOException {
		List<Avenger> list = avengerService.avengersAssemble();
		
		String json = objectMapper.writeValueAsString(list);
		
		System.out.println(json);
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print(json);
		
		response.setStatus(200);
		
	}

}
