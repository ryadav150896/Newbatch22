package com.zensar.olxadvertiseapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {
	
	private int id;
	private String title;
	private long price;
	private String category;
	private String description;
	private String userName;
	private long createdDate;
	private long modifiedDate;
	private String status;

}
