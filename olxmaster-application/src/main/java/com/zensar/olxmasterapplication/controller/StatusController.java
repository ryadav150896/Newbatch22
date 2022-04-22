package com.zensar.olxmasterapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterapplication.entity.OlxMasterStatus;

@RestController
@RequestMapping("/advertise")
public class StatusController {
	static List<OlxMasterStatus> listOfStatus=new ArrayList();
	
	static {
		
		listOfStatus.add(new OlxMasterStatus(1,"OPEN"));
		listOfStatus.add(new OlxMasterStatus(2,"CLOSED"));
	}
	//get all the status
	//http:localhost/7070/status
	@GetMapping(value="/status", produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<OlxMasterStatus> getAllStatus(){
		
		return listOfStatus;
	}
}
