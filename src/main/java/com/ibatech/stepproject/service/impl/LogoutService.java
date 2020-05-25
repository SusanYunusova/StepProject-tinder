package com.ibatech.stepproject.service.impl;

import com.ibatech.stepproject.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutService implements Service {
    @Override
    public String startProcess(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "index.jsp";
    }
}
