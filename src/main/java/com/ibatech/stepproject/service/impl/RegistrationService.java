package com.ibatech.stepproject.service.impl;

import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.entities.Users;
import com.ibatech.stepproject.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationService implements Service {
    @Override
    public String startProcess(HttpServletRequest request, HttpServletResponse response) {
        return doSaveService(request, response);
    }

    private String doSaveService(HttpServletRequest request, HttpServletResponse response) {
        Users users = getUserParams(request);
        users = (Users) DaoFactory.getDao(DaoFactory.DaoNames.USERS).create(users);
        return openLikesPage(request, response, users);
    }

    private Users getUserParams(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String imageUrl = request.getParameter("imageUrl");
        String gender = request.getParameter("gender");
        String jobTitle = request.getParameter("jobTitle");


        return Users
                .builder()
                .age(Integer.parseInt(age))
                .email(email)
                .gender(gender)
                .id(0)
                .name(name)
                .surname(surname)
                .password(password)
                .imageUrl(imageUrl)
                .jobTitle(jobTitle)
                .build();
    }
}
