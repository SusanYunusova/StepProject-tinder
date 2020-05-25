package com.ibatech.stepproject.filters;

import com.ibatech.stepproject.entities.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter
        implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    public static final String LOGIN_PAGE = "/index.jsp";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        logger.debug("starting to filter....");
        System.out.println("starting to filter....");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        try {
            Users user = (session != null) ? (Users) session.getAttribute("user") : null;
            if (user == null
                    && !request.getRequestURI().contains(LOGIN_PAGE)
                    &&request.getRequestURI().contains("register")) {
                logger.debug("sendRedirect to " + LOGIN_PAGE);
                System.out.println("sendRedirect to " + LOGIN_PAGE);
                response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
            }
            logger.debug("request ----->>>>  {}", request.getRequestURI());
            System.out.println("request ----->>>>  {}"+request.getRequestURI());
            if (request.getRequestURI().contains(LOGIN_PAGE)
                    || request.getRequestURI().contains("/StepProject_war/images/")
                    || request.getRequestURI().contains("/StepProject_war/vendor")
                    || request.getRequestURI().contains("/StepProject_war/fonts")
                    || request.getRequestURI().contains("/StepProject_war/js")
                    || request.getRequestURI().contains("/StepProject_war/css")
                    || request.getRequestURI().contains("/StepProject_war/Dispatcher")
            ||request.getRequestURI().contains("register")) {

                logger.debug("maybe resource or maybe login... :D " + request.getRequestURI());
                System.out.println("maybe resource or maybe login... :D "+ request.getRequestURI());
                chain.doFilter(request, response);
            } else {

                if (user != null) {
                    logger.debug("Nesealskdjfalksfalsdkfj*******");
                    System.out.println("Nesealskdjfalksfalsdkfj*******");
                    chain.doFilter(request, response);
                }

                if (user == null && !request.getRequestURI().contains(LOGIN_PAGE)) {
                    logger.debug("sendRedirect to " + LOGIN_PAGE);
                    System.out.println("sendRedirect to " + LOGIN_PAGE);
                    response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
                }

            }
        } catch (Exception e) {
            logger.error("Error do filter e : {}, e : {}", e, e);
            System.out.println("error do filter:"+e);
            e.printStackTrace();
        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

