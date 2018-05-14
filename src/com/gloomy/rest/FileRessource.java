package com.gloomy.rest;

import com.gloomy.dao.FileDao;
import com.gloomy.entity.Directory;
import com.gloomy.entity.FileUser;
import com.gloomy.entity.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("file")
public class FileRessource {

    private FileDao fileDao;

    public FileRessource() {
        this.fileDao = new FileDao();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void persistFile(FileUser fileUser){
        fileDao.persist(fileUser);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public FileUser readByIdFile(long id){
        FileUser fileUser = fileDao.readById(id);
        return fileUser;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateNameFile(FileUser fileUser){
        boolean bool = fileDao.updateNameFile(fileUser);
        return bool;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteFile(FileUser fileUser){
        boolean bool = fileDao.deleteFile(fileUser);
        return bool;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FileUser> getUserListFile(User user){
        List<FileUser> fileUserList = fileDao.getFileUserList(user);
        return fileUserList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FileUser> getFromDirFile(User user, Directory directory){
        List<FileUser> fileUserList = fileDao.getFileFromDir(user, directory);
        return fileUserList;
    }
}
