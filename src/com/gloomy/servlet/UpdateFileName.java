package com.gloomy.servlet;

import com.gloomy.dao.FileDao;
import com.gloomy.entity.FileUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        //TODO same than upload file
        long fileId = Long.parseLong(req.getParameter("id"));
        String newName = req.getParameter("newName");

        if (!newName.trim().isEmpty()) {
            if(!newName.contains(".")) {
                //New name with extension
                FileUser fileUser = fileDao.readById(fileId);

                fileUser.setName(newName + "." + fileUser.getName().split(Pattern.quote("."))[1]);

                fileDao.updateNameFile(fileUser);
                resp.sendRedirect(Main.URL_PATH);
            }
        }
    }
}
