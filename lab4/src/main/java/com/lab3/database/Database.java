package com.lab3.database;

import javax.persistence.*;

public class Database {
    private String PERSISTENCE_UNIT = "pu";
    private EntityManagerFactory entityManagerFactory;
    
    public Database() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }
    
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    public void closeEntityManager(EntityManager manager) {
        manager.close();
        entityManagerFactory.close();
    }
}
