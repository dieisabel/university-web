package com.lab3.domain.daos;

import java.util.List;
import javax.persistence.*;

import com.lab3.domain.models.Plant;
import com.lab3.domain.models.PlantFamily;
import com.lab3.database.Database;

public class PlantDAO {
	public List<Plant> fetchAll() {
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        Query query = manager.createNamedQuery("fetch all plants");
        List<Plant> plants = query.getResultList();
        database.closeEntityManager(manager);
        return plants;
	}

	public Plant findByName(String name) {
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        Query query = manager.createNamedQuery("find plant by name");
        query.setParameter("name", name);
        Plant plant = (Plant) query.getSingleResult();
        database.closeEntityManager(manager);
        return plant;
	}

	public void save(Plant plant) {
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        PlantFamily f = manager.find(PlantFamily.class, plant.getFamily().getId());
        plant.setFamily(f);
        manager.persist(plant);
        transaction.commit();
        database.closeEntityManager(manager);
	}

	public void delete(Plant plant) {
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Plant p = manager.find(Plant.class, plant.getId());
        manager.remove(p);
        transaction.commit();
        database.closeEntityManager(manager);
	}
}
