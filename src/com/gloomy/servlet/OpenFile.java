package com.gloomy.servlet;

import com.gloomy.dao.DirectoryDao;
import com.gloomy.dao.FileDao;
import com.gloomy.entity.Directory;
import com.gloomy.entity.FileUser;
import com.gloomy.entity.User;
import com.gloomy.util.ContentType;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.SQLException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = OpenFile.URL_PATH)
public class OpenFile extends HttpServlet {
    public static final String URL_PATH = "/auth/openfile";

    private FileDao fileDao;
    private DirectoryDao directoryDao;

    @Override
    public void init() throws ServletException {
        fileDao = new FileDao();
        directoryDao = new DirectoryDao();

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        FileUser fileUser = fileDao.readById(id);
        Directory directory;
        try {
            directory = directoryDao.getDirectoryById(fileUser.getDirectory().getId());
        } catch (NullPointerException e) {
            directory = new Directory();
            directory.setId(0);
        }
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("user");
        if (directory.getId() != 0 || currentUser.getId() == fileUser.getUser().getId() || directory.isShared()) {
            try {
                //Split to get the extension
                String[] fileNameExploded = fileUser.getName().split(Pattern.quote("."));
                String fileExtension = "."+fileNameExploded[1];

                //Create temporary file in the server
                InputStream inputStream = fileUser.getFilePart().getBinaryStream();
                File tempFile = File.createTempFile("temp", fileExtension, new File("D:/")); //Path où les preview sont extraits temporairement dans le serv (à changer)
                tempFile.deleteOnExit();
                FileOutputStream out = new FileOutputStream(tempFile);
                IOUtils.copy(inputStream, out);

                //Set content type
                String contentType = ContentType.getContentTypeWithExtension(fileExtension);
                resp.setContentType(contentType);
                resp.setStatus(200);

                //Send the content of the file to the client
                FileInputStream fileInputStreamToShow = new FileInputStream(tempFile);
                OutputStream responseOutputStream = resp.getOutputStream();
                int bytes;
                while ((bytes = fileInputStreamToShow.read()) != -1) {
                    responseOutputStream.write(bytes);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect(Main.URL_PATH);
        }
    }
}