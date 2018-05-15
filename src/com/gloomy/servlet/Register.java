package com.gloomy.servlet;

import com.gloomy.entity.User;
import com.gloomy.rest.UserResource;
import com.gloomy.util.Hash;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = Register.URL_PATH)
public class Register extends HttpServlet {
    public static final String URL_PATH = "/register";
    public static final String JSP_PATH = "/WEB-INF/register.jsp";

    private UserResource userResource;

    @Override
    public void init() throws ServletException {
        userResource = new UserResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(Register.JSP_PATH);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get all the parameters for the registration
        String fName = req.getParameter("firstname");
        String lName = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordConf = req.getParameter("passwordConf");
        String email = req.getParameter("email");

        //Check if the fields are empty
        //TODO keep good field
        if (fName.trim().isEmpty() || lName.trim().isEmpty() || username.trim().isEmpty()
                || password.trim().isEmpty() || email.trim().isEmpty()) {
            resp.sendRedirect(Register.URL_PATH);
        } else {
            //!userDAO.existeUsername(username)
            //if (!userResource.existeUsernameInJson(username)) {

            if (password.equals(passwordConf)) {

                //User creation
                User user = new User();
                user.setFirstname(fName);
                user.setLastname(lName);

                user.setUsername(username);
                user.setEmail(email);
                user.setGoogleFacebookUser(false);

                //Hash password
                String hashPassword = Hash.hashString(password);
                user.setPassword(hashPassword);



                //Save the user in DB
                userResource.saveInJson(user);

                //Redirection
                resp.sendRedirect(Login.URL_PATH);
            } else {
                resp.sendRedirect(Register.URL_PATH);
            }
            //} else {
            //    resp.sendRedirect(RegisterServlet.S_URL_PATTERN);
            //}
        }
    }
}

