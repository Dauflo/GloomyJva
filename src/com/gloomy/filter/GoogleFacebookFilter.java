package com.gloomy.filter;

import com.gloomy.entity.User;
import com.gloomy.servlet.Main;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = GoogleFacebookFilter.URL_PATH)
public class GoogleFacebookFilter implements Filter{
    public static final String URL_PATH = "/auth/gloomyauth/*";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession currentSession = httpServletRequest.getSession();

        User currentUser = (User) currentSession.getAttribute("user");

        if (!currentUser.isGoogleFacebookUser()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.sendRedirect(Main.URL_PATH);
        }
    }

    @Override
    public void destroy() {

    }
}
