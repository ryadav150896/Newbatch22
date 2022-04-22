package com.zensar.olxmasterapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterapplication.entity.OlxMasterCategories;
//Advertisement categories means 'Real Estate', 'Furniture', 'Electronic goods', 'Vehicles' etc.
@RestController
@RequestMapping("/advertise")
public class CategoryController {
	
	
	static List<OlxMasterCategories> listOfCategories=new ArrayList();
	
	static {
		
		listOfCategories.add(new OlxMasterCategories(1,"Furniture"));
		listOfCategories.add(new OlxMasterCategories(2,"Cars"));
		listOfCategories.add(new OlxMasterCategories(3,"Mobiles"));
		listOfCategories.add(new OlxMasterCategories(4,"Real Estate"));
		listOfCategories.add(new OlxMasterCategories(5,"Sports"));
	}
	//get all categories
	////http:localhost/7070/category
	@GetMapping(value="/category",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<OlxMasterCategories> getAllAdvCategories(){
		return listOfCategories;
	}

}
