package com.gloomy.rest;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.entity.Directory;
import com.gloomy.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("directory")
public class DirectoryRessource {

    private DirectoryDao directoryDao;

    public DirectoryRessource() {
        this.directoryDao = new DirectoryDao();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDirectory(Directory directory){
        directoryDao.addCDirectory(directory);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Directory getByIdDirectory(long id){
        Directory directory = directoryDao.getDirectoryById(id);
        return directory;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Directory updateDirectory(Directory directory){
        Directory directoryReturn = directoryDao.updateDirectory(directory);
        return directoryReturn;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteDirectory(Directory directory){
        boolean bool = directoryDao.deleteDirectory(directory);
        return bool;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Directory> getAllRootDirectory(User user){
        List<Directory> directoryList = directoryDao.getAllDirectoryRoot(user);
        return directoryList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Directory> getAllSubDirectory(User user, long dirId){
        List<Directory> directoryList = directoryDao.getAllSubDirectory(user, dirId);
        return directoryList;
    }
}
