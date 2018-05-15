package com.gloomy.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

@WebServlet
public class GloomyInitializer implements ServletContextListener{

    @PersistenceUnit(name = "gloomyPU")
    private EntityManagerFactory gloomy_emf;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //get the entity manager factory and create database on startup
        gloomy_emf = Persistence.createEntityManagerFactory("gloomyPU");
        PersistenceManager.setEntityManagerFactory(gloomy_emf);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        gloomy_emf.close();
    }
}
