package com.gloomy.servlet;

import com.gloomy.dao.FileDao;
import com.gloomy.dao.UserDao;
import com.gloomy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@WebServlet(urlPatterns = UploadFile.URL_PATH)
@MultipartConfig(maxFileSize = 16177215)
public class UploadFile extends HttpServlet {
    public static final String URL_PATH = "/auth/uploadfile";
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String fileName = extractFileName(part);
        long size = part.getSize();
        if (fileName != null && fileName.length() > 0) {
            // File data
            InputStream is = part.getInputStream();
            // Write to file
            try {
                FileDao fileDao = new FileDao();
                HttpSession session = req.getSession();
                User currentUser = (User) session.getAttribute("user");
                fileDao.persist(fileName, is, size, currentUser.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        resp.sendRedirect(Main.URL_PATH);
    }

    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }
}
