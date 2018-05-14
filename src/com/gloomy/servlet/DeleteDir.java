package com.gloomy.servlet;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.dao.FileDao;
import com.gloomy.entity.Directory;
import com.gloomy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = DeleteDir.URL_PATH)
public class DeleteDir extends HttpServlet {
    public static final String URL_PATH = "/auth/deletedir";
    private DirectoryDao directoryDao;
    private FileDao fileDao;

    private User currentUser;

    @Override
    public void init() throws ServletException {
        directoryDao = new DirectoryDao();
        fileDao = new FileDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get dir you want to delete
        HttpSession session = req.getSession();
        currentUser = (User) session.getAttribute("user");
        long id = Long.parseLong(req.getParameter("id"));
        Directory deleteDir = directoryDao.getDirectoryById(id);

        deleteAll(deleteDir);

        resp.sendRedirect(Main.URL_PATH);
    }

    private void deleteAll(Directory directory) {

        //check if it got sub dir
        // yes : recursion
        //no : delete all of his files, then delete him
        List<Directory> directoryList = directoryDao.getAllSubDirectory(directory.getId());

        if (directoryList.size() != 0) {
            for (Directory subDir : directoryList) {
                deleteAll(subDir);
            }
        }
        fileDao.deleteAllFilesFromDir(currentUser, directory);
        directoryDao.deleteDirectory(directory);



    }
}
