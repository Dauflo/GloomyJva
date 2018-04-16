package com.gloomy.servlet;

import com.gloomy.dao.UserDao;
import com.gloomy.entity.User;
import com.gloomy.util.Hash;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Login.URL_PATH)
public class Login extends HttpServlet {
    public static final String URL_PATH = "/login";
    public static final String JSP_PATH = "/WEB-INF/login.jsp";
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(Login.JSP_PATH);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get form information
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            resp.sendRedirect(Login.URL_PATH);
        } else {
            String hashPass = Hash.hashString(password);

            User u = userDao.authenticateUser(username, hashPass);

            if (u != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                System.out.println("Login OK");
                resp.sendRedirect(Register.URL_PATH);
            } else {
                System.out.println("Fail to login");
                resp.sendRedirect(Login.URL_PATH);
            }
        }
    }
}
