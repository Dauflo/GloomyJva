package com.gloomy.rest;

import com.gloomy.dao.UserDao;
import com.gloomy.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {
    private UserDao userDao;

    public UserResource() {
        userDao = new UserDao();
    }

    @POST @Consumes(MediaType.APPLICATION_JSON) @Path("/save")
    public User saveInJson(User user) {
        userDao.addUser(user);
        return user;
    }

    @POST @Consumes(MediaType.APPLICATION_JSON) @Path("/update")
    public User updateInJson(User user) {
        userDao.updateUser(user);
        return user;
    }

    @DELETE @Consumes(MediaType.APPLICATION_JSON) @Path("/delete")
    public boolean deleteInJson(User user) {
        userDao.deleteUser(user);
        return true;
    }

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/{id}")
    public User getOneInJson(@PathParam("id") long id) {
        return userDao.getUserById(id);
    }

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/{email}/{password}")
    public User autentificateUserInJson(@PathParam("email") String eamil, @PathParam("password") String password) {
        return userDao.authenticateUser(eamil, password);
    }

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/google/{email}")
    public User getGoogleFacebookUser(@PathParam("email") String email) {
        return userDao.getGoogleFacebookUser(email);
    }
}
