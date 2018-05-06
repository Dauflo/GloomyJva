package com.gloomy.dao;

import com.gloomy.entity.Directory;
import com.gloomy.entity.FileUser;
import com.gloomy.entity.User;
import com.gloomy.util.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileDao {
    private final EntityManagerFactory gloomy_emf;
    private Connection connection;

    private final String JDDC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/gloomydb";
    private final String USER = "root";
    private final String PASS = "";

    public FileDao() {
        gloomy_emf = PersistenceManager.getEntityManagerFactory();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {

        }
    }

    //Persist no dir
    public void persist(String fileName, InputStream is, long size, long user_id) throws SQLException {
        connection.setAutoCommit(false);
        try {
            String sql = "Insert into file(name,filePart,size,user_id) " //
                    + " values (?,?,?,?) ";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, fileName);
            pstm.setBlob(2, is);
            pstm.setLong(3, size);
            pstm.setLong(4, user_id);
            pstm.executeUpdate();
            connection.commit();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    //Persist with dir
    public void persist(String fileName, InputStream is, long size, long user_id, long directory_id) throws SQLException {
        connection.setAutoCommit(false);
        try {
            String sql = "Insert into file(name,filePart,size,user_id,directory_id) " //
                    + " values (?,?,?,?,?) ";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, fileName);
            pstm.setBlob(2, is);
            pstm.setLong(3, size);
            pstm.setLong(4, user_id);
            pstm.setLong(5, directory_id);
            pstm.executeUpdate();
            connection.commit();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    //Read
    public FileUser read(long id) throws SQLException {
        FileUser fileUser = new FileUser();
        try {
            // queries the database
            String sql = "SELECT * FROM file WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                // gets file name and file blob data
                String fileName = result.getString("name");
                Blob blob = result.getBlob("filePart");
                long size = result.getLong("size");
                fileUser.setId(id);
                fileUser.setName(fileName);
                fileUser.setFilePart(blob);
                fileUser.setSize(size);
            } else {
                // no file found
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                // closes the database connection
                try {
                    connection.close();
                    return fileUser;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

    //Update


    //Delete


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
}

