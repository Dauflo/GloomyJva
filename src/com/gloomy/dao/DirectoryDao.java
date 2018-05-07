package com.gloomy.dao;

import com.gloomy.entity.Directory;
import com.gloomy.entity.User;
import com.gloomy.util.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class DirectoryDao {

    private final EntityManagerFactory gloomy_emf;

    public DirectoryDao() {
        gloomy_emf = PersistenceManager.getEntityManagerFactory();
    }

    //Persist
    public void addCDirectory(Directory directory) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(directory);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
    }

    //Read
    public Directory getDirectoryById(long id) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Directory directory;
        try {
            entityTransaction.begin();
            directory = entityManager.find(Directory.class, id);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return directory;
    }

    //Update
    public Directory updateDirectory(Directory directory) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(directory);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return directory;
    }

    //Delete
    public boolean deleteDirectory(Directory directory) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.remove(directory);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return true;
    }

    //Get all root dir
    public List<Directory> getAllDirectoryRoot(User user) {
        List<Directory> directoryList;
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT d FROM Directory AS d WHERE d.user = :user AND d.rootDirId = 0 ORDER BY d.id");
            query.setParameter("user", user);
            directoryList = query.getResultList();
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return directoryList;
    }

    //Get all sub dir
    public List<Directory> getAllSubDirectory(User user, long dirId) {
        List<Directory> directoryList;
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT d FROM Directory AS d WHERE d.user = :user AND d.rootDirId = :rootDirId ORDER BY d.id");
            query.setParameter("user", user);
            query.setParameter("rootDirId", dirId);
            directoryList = query.getResultList();
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return directoryList;
    }
}
