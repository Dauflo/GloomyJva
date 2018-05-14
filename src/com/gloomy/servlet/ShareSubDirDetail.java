package com.gloomy.servlet;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.dao.FileDao;
import com.gloomy.entity.Directory;
import com.gloomy.entity.FileUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = ShareSubDirDetail.URL_PATH)
public class ShareSubDirDetail extends HttpServlet {
    public static final String URL_PATH = "/auth/sharesubdirdetail";
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
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = Long.parseLong(session.getAttribute("currentDirId").toString());
            session.removeAttribute("currentDirId");
        }

        Directory directory = directoryDao.getDirectoryById(id);

        req.setAttribute("directory", directory);

        List<FileUser> fileUserList = fileDao.getFileFromDir(directory);

        req.setAttribute("files", fileUserList);

        if (directory.getId() != 0) {
            List<Directory> directoryList = directoryDao.getAllSubDirectory(directory.getId());

            req.setAttribute("directories", directoryList);
        }

        RequestDispatcher rd = req.getRequestDispatcher(ShareDirectory.JSP_PATH);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
