package com.lab3.domain.models;

public class Plant {
	private int id;
	private String name;
	private float temperature;
	private String light;
	private boolean is_poisonous;
	private float size;
	public PlantFamily family;
/*	
	public Plant(String name, float temperature, String light, boolean is_poisonous, float size, PlantFamily family) {
	    this.name = name;	
	    this.temperature = temperature;
	    this.light = light;
	    this.is_poisonous = is_poisonous;
	    this.size = size;
	    this.family = family;
	}
*/	
	public Plant(int id, String name, float temperature, String light, boolean is_poisonous, float size, PlantFamily family) {
		this.id = id;
	    this.name = name;	
	    this.temperature = temperature;
	    this.light = light;
	    this.is_poisonous = is_poisonous;
	    this.size = size;
	    this.family = family;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
	    return name;	
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public float getTemperature() {
	    return temperature;	
	}
}
