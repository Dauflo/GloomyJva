package com.gloomy.dao;

import com.gloomy.entity.User;
import com.gloomy.util.PersistenceManager;

import javax.persistence.*;

public class UserDao {

    private final EntityManagerFactory gloomy_emf;

    public UserDao() {
        gloomy_emf = PersistenceManager.getEntityManagerFactory();
    }

    //Persist
    public void addUser(User u) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(u);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
    }

    //Read
    public User getUserById(long id) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        User u;
        try {
            entityTransaction.begin();
            u = entityManager.find(User.class, id);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return u;
    }

    //Update
    public User updateUser(User u) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(u);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return u;
    }

    //Delete
    public boolean deleteUser(User u) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.remove(u);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return true;
    }

    //Get existent user by email and password
    public User authenticateUser(String email, String passwprd) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        User u;
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT u FROM User AS u WHERE u.email = :email AND u.password = :password AND u.googleFacebookUser = false");
            query.setParameter("email", email);
            query.setParameter("password", passwprd);
            try {
                u = (User) query.getSingleResult();
            } catch (NoResultException e) {
                u = null;
            }
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return u;
    }

    //Get existant user by email, use for google connection and facebook
    public User getGoogleFacebookUser(String email) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        User u;
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT u FROM User AS u WHERE u.email = :email");
            query.setParameter("email", email);
            try {
                u = (User) query.getSingleResult();
            } catch (NoResultException e) {
                u = null;
            }
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return u;
    }
}
