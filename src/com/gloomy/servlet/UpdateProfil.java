package com.gloomy.servlet;

import com.gloomy.dao.UserDao;
import com.gloomy.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = UpdateProfil.URL_PATH)
public class UpdateProfil extends HttpServlet {
    public static final String URL_PATH = "/auth/updateprofil";
    public static final String JSP_PATH = "/WEB-INF/auth/updateprofil.jsp";
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(UpdateProfil.JSP_PATH);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get all fields from form
        //TODO GOOGLE ACCOUNT
        String fName = req.getParameter("firstname");
        String lName = req.getParameter("lastname");
        String username = req.getParameter("username");

        if (fName.trim().isEmpty() || lName.trim().isEmpty() || username.trim().isEmpty()) {
            resp.sendRedirect(UpdateProfil.URL_PATH);
        } else {
            HttpSession currentSession = req.getSession();

            User currentUser = (User) currentSession.getAttribute("user");

            currentUser.setFirstname(fName);
            currentUser.setLastname(lName);
            currentUser.setUsername(username);

            userDao.updateUser(currentUser);

            currentSession.removeAttribute("user");
            currentSession.setAttribute("user", currentUser);

            resp.sendRedirect(Main.URL_PATH);
        }
    }
}
