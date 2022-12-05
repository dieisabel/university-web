package com.lab3.domain.models;

public class Plant {
	private int id;
	private String name;
	private float temperature;
	private String light;
	private boolean is_poisonous;
	private float size;
	public PlantFamily family;

	public Plant(String name, float temperature, String light, boolean is_poisonous, float size, PlantFamily family) {
	    this.name = name;	
	    this.temperature = temperature;
	    this.light = light;
	    this.is_poisonous = is_poisonous;
	    this.size = size;
	    this.family = family;
	}

	public Plant(int id, String name, float temperature, String light, boolean is_poisonous, float size, PlantFamily family) {
		this.id = id;
	    this.name = name;	
	    this.temperature = temperature;
	    this.light = light;
	    this.is_poisonous = is_poisonous;
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

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public float getTemperature() {
	    return temperature;	
	}
	
	public void setLight(String ligth) {
		this.light = light;
	}
	
	public String getLight() {
	    return light;	
	}
	
	public void setIsPoisonous(boolean is_poisonous) {
	    this.is_poisonous = is_poisonous;	
	}
	
	public boolean getIsPoisonous() {
		return is_poisonous;
	}
	
	public void setSize(float size) {
		this.size = size;
	}
	
	public float getSize() {
		return size;
	}
	
	public void setPlantFamily(PlantFamily family) {
		this.family = family;
	}
	
	public PlantFamily getPlantFamily() {
	    return family;	
	}
}
