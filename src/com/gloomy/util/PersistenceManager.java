package com.gloomy.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static EntityManagerFactory gloomy_emf;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (gloomy_emf == null) {
            gloomy_emf = Persistence.createEntityManagerFactory("gloomyPU");
        }
        return gloomy_emf;
    }

    public static void setEntityManagerFactory(EntityManagerFactory emf) {
        gloomy_emf = emf;
    }
}
