package com.gloomy.dao;

import com.gloomy.entity.User;
import com.gloomy.util.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

    //Get existent user by username and password
    public User authenticateUser(String username, String passwprd) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        User u;
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT u FROM User AS u WHERE u.username = :username AND u.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", passwprd);
            u = (User) query.getSingleResult();
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
