package com.lab3;

import java.util.Optional;
import java.util.List;

import com.lab3.domain.daos.PlantDAO;
import com.lab3.domain.models.Plant;

class Main {
	public static void main(String[] args) {
		PlantDAO dao = new PlantDAO();
		List<Plant> plants = dao.fetchAll();
		
		for (Plant plant : plants) {
			System.out.println(plant.family.getName());
		}
	}
}
