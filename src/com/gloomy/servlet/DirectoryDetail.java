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

@WebServlet(urlPatterns = DirectoryDetail.URL_PATH)
public class DirectoryDetail extends HttpServlet{
    public static final String URL_PATH = "/auth/directorydetail";
    public static final String JSP_PATH = "/WEB-INF/auth/directory.jsp";
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

        long id;
        try {
           id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = Long.parseLong(session.getAttribute("currentDirId").toString());
            session.removeAttribute("currentDirId");
        }

        Directory directory = directoryDao.getDirectoryById(id);

        req.setAttribute("directory", directory);

        //Get shared
        if (directory.isShared()) {
            req.setAttribute("shareUrl", "http://localhost:8080/auth/sharefolder?link="+directory.getShareLink());
        }

        //Get path
        String path = getPath(directory.getRootDirId(), directory.getName());

        req.setAttribute("path", path);

        List<FileUser> fileUserList = fileDao.getFileFromDir(currentUser, directory);

        req.setAttribute("files", fileUserList);

        if (directory.getId() != 0) {
            List<Directory> directoryList = directoryDao.getAllSubDirectory(directory.getId());

            req.setAttribute("directories", directoryList);
        }

        RequestDispatcher rd = req.getRequestDispatcher(DirectoryDetail.JSP_PATH);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private String getPath(long rootId, String fullPath) {
        if (rootId == 0) {
            return fullPath + " >";
        } else {
            Directory currentDir = directoryDao.getDirectoryById(rootId);
            return getPath(currentDir.getRootDirId(), currentDir.getName() + " > " + fullPath);
        }
    }
}
