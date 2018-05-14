package com.gloomy.servlet;

import com.gloomy.dao.SupportDao;
import com.gloomy.dao.UserDao;
import com.gloomy.entity.Support;
import com.gloomy.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = AddTicket.URL_PATH)
public class AddTicket extends HttpServlet {

    public static final String URL_PATH = "/auth/addTicket";
    public static final String JSP_PATH = "/WEB-INF/auth/addTicket.jsp";

    private SupportDao supportDao;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        supportDao = new SupportDao();
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get ticket parameters
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String state = "1";

        //Get current user
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        //Create object
        Support support = new Support();
        support.setTitle(title);
        support.setContent(content);
        support.setState(state);
        support.setUser(user);

        //Insert into DB
        supportDao.addTicket(support);

        resp.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(AddTicket.JSP_PATH);
        rd.forward(req, resp);
    }
}
