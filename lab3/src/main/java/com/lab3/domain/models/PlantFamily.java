package com.lab3.domain.models;

public class PlantFamily {
	private int id;
	private String name;
	
	public PlantFamily(String name) {
		this.name = name;
	}
	
	public PlantFamily(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
