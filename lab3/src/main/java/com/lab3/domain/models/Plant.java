package com.lab3.domain.models;

public class Plant {
	private int id;
	private String name;
	private double temperature;
	private String light;
	private boolean isPoisonous;
	private double size;
	public PlantFamily family;

	public Plant(String name, double temperature, String light, boolean isPoisonous, double size, PlantFamily family) {
	    this.name = name;	
	    this.temperature = temperature;
	    this.light = light;
	    this.isPoisonous = isPoisonous;
	    this.size = size;
	    this.family = family;
	}

	public Plant(int id, String name, double temperature, String light, boolean isPoisonous, double size, PlantFamily family) {
		this.id = id;
	    this.name = name;	
	    this.temperature = temperature;
	    this.light = light;
	    this.isPoisonous = isPoisonous;
	    this.size = size;
	    this.family = family;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public double getTemperature() {
	    return temperature;	
	}
	
	public void setLight(String light) {
		this.light = light;
	}
	
	public String getLight() {
	    return light;	
	}
	
	public void setIsPoisonous(boolean isPoisonous) {
	    this.isPoisonous = isPoisonous;	
	}
	
	public boolean getIsPoisonous() {
		return isPoisonous;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public double getSize() {
		return size;
	}
	
	public void setFamily(PlantFamily family) {
		this.family = family;
	}
	
	public PlantFamily getFamily() {
	    return family;	
	}
}
