package com.gloomy.servlet;

import com.gloomy.dao.FileDao;
import com.gloomy.entity.FileUser;
import com.gloomy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = DeleteFile.URL_PATH)
public class DeleteFile extends HttpServlet {
    public static final String URL_PATH = "/auth/deletefile";
    private FileDao fileDao;

    @Override
    public void init() throws ServletException {
        fileDao = new FileDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long fileId = Long.parseLong(req.getParameter("id"));

        FileUser fileUser = fileDao.readById(fileId);

        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("user");

        fileDao.deleteFile(currentUser, fileUser);

        try {
            long currentDirId = Long.parseLong(req.getParameter("currentDirID"));
            session = req.getSession();
            session.setAttribute("currentDirId", currentDirId);
            resp.sendRedirect(DirectoryDetail.URL_PATH);
        } catch (Exception e) {
            resp.sendRedirect(Main.URL_PATH);
        }
    }
}
