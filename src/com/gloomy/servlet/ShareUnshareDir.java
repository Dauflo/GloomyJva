package com.gloomy.servlet;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.entity.Directory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = ShareUnshareDir.URL_PATH)
public class ShareUnshareDir extends HttpServlet {
    public static final String URL_PATH = "/auth/shareunsharedir";
    private DirectoryDao directoryDao;

    @Override
    public void init() throws ServletException {
        directoryDao = new DirectoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        Directory directory = directoryDao.getDirectoryById(id);

        if (directory.isShared()) {
            directory.setShared(false);
        } else {
            directory.setShared(true);
        }

        directoryDao.updateDirectory(directory);

        resp.sendRedirect(Main.URL_PATH);
    }
}
