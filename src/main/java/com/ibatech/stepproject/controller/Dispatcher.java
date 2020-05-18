package com.ibatech.stepproject.controller;

import com.ibatech.stepproject.controller.internalService.UrlResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Dispatcher" ,urlPatterns = "/Dispatcher")
public class Dispatcher extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UrlResolver resolver = new UrlResolver(request,response);
        String url = resolver.getUrl();
        request.getRequestDispatcher(url).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
