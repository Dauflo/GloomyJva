package com.gloomy.rest;

import com.gloomy.dao.UserDao;
import com.gloomy.entity.User;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("user")
public class UserRessource {

    private UserDao userDao;

    public UserRessource() {
        this.userDao = new UserDao();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User user){
        userDao.addUser(user);
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User getUser(Long id){
        User user = userDao.getUserById(id);
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(User user){
        userDao.deleteUser(user);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User authenticateUser(String email, String password){
        User user = userDao.authenticateUser(email, password);
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User getGoogleFacebookUser(String email){
        User user = userDao.getGoogleFacebookUser(email);
        return user;
    }
}
