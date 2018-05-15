package com.gloomy.util;

import com.sun.jersey.spi.container.servlet.ServletContainer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
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

        //get the servlet context
        ServletContext ctx = servletContextEvent.getServletContext();

        //register all the servlet at the application start up
        ServletRegistration.Dynamic jerseyServlet = ctx.addServlet("jersey-serlvet",new ServletContainer());
        jerseyServlet.addMapping("/api/*");
        jerseyServlet.setLoadOnStartup(1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        gloomy_emf.close();
    }
}
