package com.gloomy.servlet;

import com.gloomy.dao.UserDao;
import com.gloomy.entity.User;
import com.gloomy.rest.UserRessource;
import com.gloomy.util.Hash;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = UpdatePassword.URL_PATH)
public class UpdatePassword extends HttpServlet {
    public static final String URL_PATH = "/auth/gloomyauth/updatepassword";
    public static final String JSP_PATH = "/WEB-INF/auth/updatepassword.jsp";

    private UserRessource userRessource;

    @Override
    public void init() throws ServletException {
        userRessource = new UserRessource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(UpdatePassword.JSP_PATH);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get all fields
        String pass = req.getParameter("password");
        String confpass = req.getParameter("confirmation");

        if (pass.trim().isEmpty() || confpass.trim().isEmpty()) {
            resp.sendRedirect(UpdatePassword.URL_PATH);
        } else {
            if (pass.equals(confpass)) {
                String hashPass = Hash.hashString(pass);

                HttpSession currentSession = req.getSession();
                User user = (User) currentSession.getAttribute("user");

                user.setPassword(hashPass);

                userRessource.updateUser(user);

                currentSession.removeAttribute("user");
                currentSession.setAttribute("user", user);

                resp.sendRedirect(Main.URL_PATH);
            } else {
                resp.sendRedirect(UpdatePassword.URL_PATH);
            }
        }
    }
}
