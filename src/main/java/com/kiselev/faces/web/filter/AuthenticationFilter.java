package com.kiselev.faces.web.filter;

import com.kiselev.faces.common.entities.ProfileEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String url = request.getRequestURI();

        ProfileEntity session = (ProfileEntity) request.getSession().getAttribute("profile");

        if (session == null) {
            if (url.contains("settings")) {
                response.sendRedirect(request.getContextPath() + "/signin");
            } else {
                chain.doFilter(req, res);
            }
        } else {
            if (url.contains("signin") || url.contains("signup") ||
                    url.contains("register") || url.contains("session") || (url.length() == 1)) {

                if (session.getUrlName() != null) {
                    response.sendRedirect(request.getContextPath() + "/" + session.getUrlName());
                } else {
                    response.sendRedirect(request.getContextPath() + "/id" + session.getId());
                }

            } else {
                chain.doFilter(req, res);
            }
        }
    }

    public void destroy() {

    }
}
