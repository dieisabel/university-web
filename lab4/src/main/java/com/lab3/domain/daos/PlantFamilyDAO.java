package com.lab3.domain.daos;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.*;

import com.lab3.domain.models.PlantFamily;
import com.lab3.database.Database;

public class PlantFamilyDAO {
	public List<PlantFamily> fetchAll() {
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        Query query = manager.createNamedQuery("fetch all plant families");
        List<PlantFamily> families = query.getResultList();
        database.closeEntityManager(manager);
        return families;
	}
    
	public PlantFamily findByName(String name) {
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        Query query = manager.createNamedQuery("find plant family by name");
        query.setParameter("name", name);
        PlantFamily family = (PlantFamily) query.getSingleResult();
        database.closeEntityManager(manager);
        return family;
    }

	public void save(PlantFamily family) {
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(family);
        transaction.commit();
        database.closeEntityManager(manager);
	}

	public void delete(PlantFamily family) {
        Database database = new Database();
        EntityManager manager = database.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        PlantFamily f = manager.find(PlantFamily.class, family.getId());
        manager.remove(f);
        transaction.commit();
        database.closeEntityManager(manager);
	}
}
