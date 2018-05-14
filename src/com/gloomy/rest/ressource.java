package com.gloomy.rest;

import com.gloomy.dao.UserDao;
import com.gloomy.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/user")
public class ressource {

    private UserDao userDao;

    @POST
    @Path("/create")
    public String create(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname, @FormParam("username") String username,
                         @FormParam("password") String password, @FormParam("email") String email){

        //Create User object
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);

        //Insert into DB
        this.userDao = new UserDao();
        userDao.addUser(user);
        return lastname  + " OK";

    }
}
