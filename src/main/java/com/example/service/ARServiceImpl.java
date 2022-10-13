package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.CitizenApp;
import com.example.repository.CitizenAppRepo;

@Service
public class ARServiceImpl implements ARService{
    
	@Autowired
	private CitizenAppRepo appRepo;

	public Integer createApplication(CitizenApp app) {
		String endpointUrl= "https://ssa-web-api.herokuapp.com/ssn/{ssn}";
		
		RestTemplate rt= new RestTemplate();
		ResponseEntity<String> responseEntity = rt.getForEntity(endpointUrl, String.class, app.getSsn());
		 String stateName= responseEntity.getBody();
		 
		 if("New Jersey".equals(stateName))
		 {
			 
			 CitizenApp entity= new CitizenApp();
			BeanUtils.copyProperties(app, entity);
			entity.setStateName(stateName);
			CitizenApp save = appRepo.save(entity);
			 return save.getAppId();
		 }
		
		return 0;
	}

}
