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
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = ShareDirectory.URL_PATH)
public class ShareDirectory extends HttpServlet {
    public static final String URL_PATH = "/auth/sharefolder";
    public static final String JSP_PATH = "/WEB-INF/auth/shareDir.jsp";
    public static final String JSP_PATH_NOT_SHARED = "/WEB-INF/auth/notSharedDir.jsp";
    private DirectoryDao directoryDao;
    private FileDao fileDao;

    @Override
    public void init() throws ServletException {
        directoryDao = new DirectoryDao();
        fileDao = new FileDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = req.getParameter("link");

        Directory directory = directoryDao.getDirByLink(link);

        if (directory == null) {
            RequestDispatcher rd = req.getRequestDispatcher(ShareDirectory.JSP_PATH_NOT_SHARED);
            rd.forward(req, resp);
            System.out.println("Bad");
        } else {
            System.out.println("Good");
            //Get file into dir
            List<FileUser> fileUserList = fileDao.getFileFromDir(directory);
            req.setAttribute("files", fileUserList);

            req.setAttribute("directory", directory);

            if (directory.getId() != 0) {
                List<Directory> directoryList = directoryDao.getAllSubDirectory(directory.getId());

                req.setAttribute("directories", directoryList);
            }

            RequestDispatcher rd = req.getRequestDispatcher(ShareDirectory.JSP_PATH);
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
