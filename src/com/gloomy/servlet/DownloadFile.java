package com.gloomy.servlet;

import com.gloomy.dao.FileDao;
import com.gloomy.entity.FileUser;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

@WebServlet(urlPatterns = DownloadFile.URL_PATH)
public class DownloadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int BUFFER_SIZE = 4096;
    public static final String URL_PATH = "/auth/downloadfile";
    private FileDao fileDao;

    @Override
    public void init() throws ServletException {
        fileDao = new FileDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doPost(req, resp);
        long id = Long.parseLong(req.getParameter("id"));

        try {
            FileUser fileUser = fileDao.readById(id);
            InputStream inputStream = fileUser.getFilePart().getBinaryStream();
            int fileLength = inputStream.available();

            System.out.println("fileLength = " + fileLength);

            ServletContext context = getServletContext();

            // sets MIME type for the file download
            String mimeType = context.getMimeType(fileUser.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            // set content properties and header attributes for the response
            resp.setContentType(mimeType);
            resp.setContentLength(fileLength);
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", fileUser.getName());
            resp.setHeader(headerKey, headerValue);

            // writes the file to the client
            OutputStream outStream = resp.getOutputStream();

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

                inputStream.close();
                outStream.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            resp.getWriter().print("SQL Error: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            resp.getWriter().print("IO Error: " + ex.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
