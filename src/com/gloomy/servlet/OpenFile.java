package com.gloomy.servlet;

import com.gloomy.dao.FileDao;
import com.gloomy.entity.FileUser;
import com.gloomy.util.ContentType;
import org.apache.commons.io.IOUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/openFile")
public class OpenFile extends HttpServlet {

    private FileDao fileDao;
    public static final String S_JSP_PATTERN = "/auth/openFile.jsp";

    @Override
    public void init() throws ServletException {
        fileDao = new FileDao();

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id  = Long.parseLong(req.getParameter("id"));
        try {
            //Get the file from DB
            FileUser fileUser = fileDao.readById(id);

            //Split to get the extension
            String[] fileNameExploded = fileUser.getName().split("\\.");
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
        }
        catch (SQLException ex){
            ex.printStackTrace();
            resp.getWriter().print("SQL Error: " + ex.getMessage());
        }
    }
}
