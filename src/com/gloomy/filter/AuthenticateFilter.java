package com.gloomy.filter;

import com.gloomy.servlet.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = AuthenticateFilter.URL_PATH)
public class AuthenticateFilter implements Filter{
    public static final String URL_PATH = "/auth/*";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession currentSession = httpServletRequest.getSession();

        if (currentSession.getAttribute("user") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.sendRedirect(Login.URL_PATH);
        }
    }

    @Override
    public void destroy() {

    }
}
