package com.gloomy.dao;

import com.gloomy.entity.Directory;
import com.gloomy.entity.User;
import com.gloomy.util.PersistenceManager;

import javax.persistence.*;
import java.util.List;

public class DirectoryDao {

    private final EntityManagerFactory gloomy_emf;

    public DirectoryDao() {
        gloomy_emf = PersistenceManager.getEntityManagerFactory();
    }

    //Persist
    public void addDirectory(Directory directory) {
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
            entityManager.remove(entityManager.merge(directory));
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
    public List<Directory> getAllSubDirectory(long dirId) {
        List<Directory> directoryList;
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT d FROM Directory AS d WHERE d.rootDirId = :rootDirId ORDER BY d.id");
            //query.setParameter("user", user);
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

    //Get dir by share link
    public Directory getDirByLink(String link) {
        Directory directory;
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT d FROM Directory AS d WHERE d.shareLink = :link AND d.shared = true");
            query.setParameter("link", link);
            try {
                directory = (Directory) query.getSingleResult();
            } catch (NoResultException e) {
                directory = null;
            }
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return directory;
    }
}
