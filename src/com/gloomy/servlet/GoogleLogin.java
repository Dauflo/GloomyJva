package com.gloomy.servlet;

import com.gloomy.dao.UserDao;
import com.gloomy.entity.User;
import com.gloomy.util.Hash;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@WebServlet(urlPatterns = GoogleLogin.URL_PATH)
public class GoogleLogin extends HttpServlet{
    public static final String URL_PATH = "/googleconnection/login";

    private static final JacksonFactory jacksonFactory = new JacksonFactory();

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_token = req.getParameter("token");
        System.out.println(id_token);

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), jacksonFactory)
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList("947353537310-fieofubb16lojooivoisohvm2gm5mef0.apps.googleusercontent.com"))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();

// (Receive idTokenString by HTTPS POST)

        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(id_token);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        if (idToken != null) {
            Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            String name = (String) payload.get("name");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");

            //Get the user if exist
            User currentUser = userDao.getGoogleFacebookUser(email);
            if (currentUser == null) {
                //Create user
                currentUser = new User();
                currentUser.setFirstname(givenName);
                currentUser.setLastname(familyName);
                currentUser.setUsername(givenName);
                currentUser.setEmail(email);
                currentUser.setGoogleFacebookUser(true);
                currentUser.setPassword(Hash.hashString(Hash.getSaltString()));

                userDao.addUser(currentUser);
                currentUser = userDao.getGoogleFacebookUser(email);
            }
            HttpSession session = req.getSession();
            session.setAttribute("user", currentUser);
            System.out.println("Login OK");
            resp.sendRedirect(Main.URL_PATH);

        } else {
            System.out.println("Invalid ID token.");
        }
    }
}
