package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CitizenApp;
import com.example.service.ARService;

@RestController
public class ARController {
	
	
	@Autowired
	private ARService service;
	
	@PostMapping("/app")
	public ResponseEntity<String> createCitizenAoo(@RequestBody CitizenApp app){
		
		Integer appId = service.createApplication(app);
		
		if(appId > 0)
		{
			return new ResponseEntity<String>("Id of Application is " + appId , HttpStatus.OK);
		}else
		{
			return new ResponseEntity<String>("Invalid SSN" , HttpStatus.BAD_REQUEST);
		}
			
		
	}

}
