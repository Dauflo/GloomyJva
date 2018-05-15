package com.gloomy.servlet;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.entity.Directory;
import com.gloomy.entity.User;
import com.gloomy.util.Hash;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = AddDirectory.URL_PATH)
public class AddDirectory extends HttpServlet{
    public static final String URL_PATH = "/auth/addDirectory";

    private DirectoryDao directoryDao;

    @Override
    public void init() throws ServletException {
        directoryDao = new DirectoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String directoryName = req.getParameter("directory");
        long rootDirId = Long.parseLong(req.getParameter("rootDirId"));

        if (directoryName.trim().isEmpty()) {
            resp.sendRedirect(Main.URL_PATH);
        } else {
            HttpSession session = req.getSession();
            User currentUser = (User) session.getAttribute("user");
            Directory directory = new Directory();
            directory.setName(directoryName);
            directory.setUser(currentUser);
            directory.setRootDirId(rootDirId);
            directory.setShared(false);
            directory.setShareLink(Hash.getSaltString());
            directoryDao.addDirectory(directory);

            //resp.sendRedirect(Main.URL_PATH);

            if (rootDirId == 0) {
                resp.sendRedirect(Main.URL_PATH);
            } else {
                session.setAttribute("currentDirId", rootDirId);
                resp.sendRedirect(DirectoryDetail.URL_PATH);
            }
        }
    }
}
