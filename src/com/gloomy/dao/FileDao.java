package com.gloomy.dao;

import com.gloomy.entity.Directory;
import com.gloomy.entity.FileUser;
import com.gloomy.entity.User;
import com.gloomy.util.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

//TODO interface
public class FileDao {
    private final EntityManagerFactory gloomy_emf;

    public FileDao() {
        gloomy_emf = PersistenceManager.getEntityManagerFactory();
    }

    //Persist
    public void persist(FileUser fileUser) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(fileUser);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
    }

    //Read
    public FileUser readById(long id) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        FileUser fileUser;
        try {
            entityTransaction.begin();
            fileUser = entityManager.find(FileUser.class, id);
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return fileUser;
    }

    //Update
    public boolean updateNameFile(User user, FileUser fileUser) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("UPDATE FileUser SET name = :name WHERE id = :fileId AND user = :user");
            query.setParameter("name", fileUser.getName());
            query.setParameter("fileId", fileUser.getId());
            query.setParameter("user", user);
            query.executeUpdate();
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return true;
    }

    //Delete
    public boolean deleteFile(User user, FileUser fileUser) {
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("DELETE FROM FileUser AS f WHERE f.id = :id AND f.user = :user");
            query.setParameter("id", fileUser.getId());
            query.setParameter("user", user);
            query.executeUpdate();
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return true;
    }

    //Give 10 first
    public List<FileUser> getFileUserList(User user) {
        List<FileUser> fileUserList = new ArrayList<FileUser>();
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT f FROM FileUser AS f WHERE f.user = :user AND f.directory IS NULL ORDER BY f.id");
            query.setParameter("user", user);
            fileUserList = query.getResultList();
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return fileUserList;
    }

    //Get file from dir
    public List<FileUser> getFileFromDir(Directory directory) {
        List<FileUser> fileUserList = new ArrayList<FileUser>();
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT f FROM FileUser AS f WHERE f.directory = :directory ORDER BY f.id");
            query.setParameter("directory", directory);
            fileUserList = query.getResultList();
            entityTransaction.commit();
        } finally {
            if(entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return fileUserList;
    }

    public List<FileUser> getFileFromDir(User user, Directory directory) {
        List<FileUser> fileUserList = new ArrayList<FileUser>();
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT f FROM FileUser AS f WHERE f.user = :user AND f.directory = :directory ORDER BY f.id");
            query.setParameter("user", user);
            query.setParameter("directory", directory);
            fileUserList = query.getResultList();
            entityTransaction.commit();
        } finally {
            if(entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }
        return fileUserList;
    }

    //Get total size
    public long totalSize(User user) {
        long totalSize = 0;
        List<Long> sizes;
        EntityManager entityManager = gloomy_emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("SELECT f.size FROM FileUser AS f WHERE f.user = :user");
            query.setParameter("user", user);
            sizes = query.getResultList();
            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            entityManager.close();
        }

        for (long size : sizes) {
            totalSize += size;
        }
        return totalSize;
    }
}

