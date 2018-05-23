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
import java.util.regex.Pattern;

@WebServlet(urlPatterns = UpdateFileName.URL_PATH)
public class UpdateFileName extends HttpServlet {
    public static final String URL_PATH = "/auth/updatefilename";
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
        String newName = req.getParameter("newName");

        if (!newName.trim().isEmpty()) {
            if(!newName.contains(".")) {
                //New name with extension
                FileUser fileUser = fileDao.readById(fileId);

                fileUser.setName(newName + "." + fileUser.getName().split(Pattern.quote("."))[1]);

                HttpSession session = req.getSession();
                User currentUser = (User) session.getAttribute("user");

                fileDao.updateNameFile(currentUser, fileUser);


                long currentDirId;
                try {
                    currentDirId = fileUser.getDirectory().getId();
                } catch (NullPointerException e) {
                    currentDirId = 0;
                }

                if (currentDirId == 0) {
                    resp.sendRedirect(Main.URL_PATH);
                } else {
                    session.setAttribute("currentDirId", fileUser.getDirectory().getId());
                    resp.sendRedirect(DirectoryDetail.URL_PATH);
                }
            }
        }
    }
}
