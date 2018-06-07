package com.gloomy.servlet;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.dao.FileDao;
import com.gloomy.entity.Directory;
import com.gloomy.entity.FileUser;
import com.gloomy.entity.User;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet(urlPatterns = UploadFile.URL_PATH)
@MultipartConfig(maxFileSize = 1000000000) // 16177215 46177215
public class UploadFile extends HttpServlet {
    public static final String URL_PATH = "/auth/uploadfile";
    private DirectoryDao directoryDao;
    private long maxSize = 30000000000L;


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
        Part part = req.getPart("file");
        String fileName = extractFileName(part);
        long size = part.getSize();

        long directoryId = Long.parseLong(req.getParameter("category"));

        long currentDirId = Long.parseLong(req.getParameter("currentDirID"));

        if (fileName != null && fileName.length() > 0) {
            // File data
            InputStream is = part.getInputStream();

            Blob blob = null;
            try {
                blob = new SerialBlob(IOUtils.toByteArray(is));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Write to file
            FileDao fileDao = new FileDao();
            HttpSession session = req.getSession();
            User currentUser = (User) session.getAttribute("user");

            FileUser fileUser = new FileUser();
            fileUser.setName(fileName);
            fileUser.setFilePart(blob);
            fileUser.setSize(size);
            fileUser.setUser(currentUser);

            //get total size
            long totalSize = fileDao.totalSize(currentUser);

            totalSize += size;

            if (totalSize <= maxSize) {
                if (directoryId != 0) {
                    Directory directory = directoryDao.getDirectoryById(directoryId);
                    fileUser.setDirectory(directory);
                }
                fileDao.persist(fileUser);
            } else {
                System.out.println("max");
            }
        }

        if (currentDirId == 0) {
            resp.sendRedirect(Main.URL_PATH);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("currentDirId", currentDirId);
            resp.sendRedirect(DirectoryDetail.URL_PATH);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }
}
