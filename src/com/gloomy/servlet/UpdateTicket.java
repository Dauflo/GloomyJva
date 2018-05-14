package com.gloomy.servlet;

import com.gloomy.dao.SupportDao;
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

@WebServlet(urlPatterns = UpdateTicket.URL_PATH)
public class UpdateTicket extends HttpServlet {

    public static final String URL_PATH = "/auth/updateTicket";
    public static final String JSP_PATH = "/WEB-INF/auth/ticket.jsp";

    private SupportDao supportDao;

    @Override
    public void init() throws ServletException {
        supportDao = new SupportDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Get parameters
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        //Get current session
        HttpSession session = req.getSession();

        //TODO: verif si c'est bon le utilisateur

        //Get older ticket
        Support support = (Support) session.getAttribute("support");

        //Object to update
        support.setTitle(title);
        support.setContent(content);

        //Update into DB
        supportDao.updateTicket(support);

        //Unset ticket
        session.removeAttribute("support");

        //Redirect user
        resp.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id  = Long.parseLong(req.getParameter("id"));
        Support support = supportDao.getByIdTicket(id);

        req.setAttribute("title", "title");
        req.setAttribute("content", support.getContent());

        HttpSession session = req.getSession();
        session.setAttribute("support", support);

        RequestDispatcher rd = req.getRequestDispatcher(UpdateTicket.JSP_PATH);
        rd.forward(req, resp);
    }
}
