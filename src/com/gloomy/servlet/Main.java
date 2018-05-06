package com.gloomy.servlet;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.dao.FileDao;
import com.gloomy.entity.Directory;
import com.gloomy.entity.FileUser;
import com.gloomy.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = Main.URL_PATH)
public class Main extends HttpServlet {
    public static final String URL_PATH = "/auth/main";
    public static final String JSP_PATH = "/WEB-INF/auth/main.jsp";
    private FileDao fileDao;
    private DirectoryDao directoryDao;

    @Override
    public void init() throws ServletException {
        fileDao = new FileDao();
        directoryDao = new DirectoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("user");

        List<FileUser> fileUserList = fileDao.getFileUserList(currentUser);
        req.setAttribute("files", fileUserList);

        List<Directory> directoryList = directoryDao.getAllDirectory(currentUser);
        req.setAttribute("directories", directoryList);

        RequestDispatcher rd = req.getRequestDispatcher(Main.JSP_PATH);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
