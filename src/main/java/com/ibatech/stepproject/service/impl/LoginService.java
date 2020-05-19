package com.ibatech.stepproject.service.impl;

import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.dao.impl.UsersDao;
import com.ibatech.stepproject.entities.Users;
import com.ibatech.stepproject.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginService implements Service {
    @Override
    public String startProcess(HttpServletRequest request, HttpServletResponse response) {
        return doLoginService(request, response);
    }

    private String doLoginService(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Dao<Users> dao = DaoFactory.getDao(DaoFactory.DaoNames.USERS);

        Optional<Users> user = ((UsersDao) dao).getByEmailAndPassword(email, password);

        return user.map(usr -> openLikesPage(request, response, user.get())).orElseGet(() -> "index.jsp");

    }
}
