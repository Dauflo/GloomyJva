package com.gloomy.servlet;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.entity.Directory;
import com.gloomy.rest.DirectoryRessource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = UpdateDirectoryName.URL_PATH)
public class UpdateDirectoryName extends HttpServlet {
    public static final String URL_PATH = "/auth/updatedirectoryname";

    private DirectoryRessource directoryRessource;

    @Override
    public void init() throws ServletException {
        directoryRessource = new DirectoryRessource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO same than upload file
        long directoryId = Long.parseLong(req.getParameter("directoryId"));
        String newName = req.getParameter("name");

        Directory directory = directoryRessource.getByIdDirectory(directoryId);
        directory.setName(newName);
        directoryRessource.updateDirectory(directory);

        resp.sendRedirect(Main.URL_PATH);
    }
}
