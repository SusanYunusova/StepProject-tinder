package com.ibatech.stepproject.service.impl;

import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.dao.impl.UsersDao;
import com.ibatech.stepproject.entities.Logging_log;
import com.ibatech.stepproject.entities.Users;
import com.ibatech.stepproject.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;

public class LoginService implements Service {
    @Override
    public String startProcess(HttpServletRequest request, HttpServletResponse response) {
        return doLoginService(request, response);
    }

    private String doLoginService(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Dao<Users> dao = DaoFactory.getDao(DaoFactory.DaoNames.USERS);
            System.out.println("email:"+email);
            System.out.println("password:"+password);
            Optional<Users> user = ((UsersDao) dao).getByEmailAndPassword(email, password);
            System.out.println("userId:"+user.get().getId());
            createLoggingTime(user.get());

            return user.map(usr -> openLikesPage(request, response, user.get())).orElseGet(() -> "index.jsp");

        } catch (Exception e) {
            System.out.println("error do login:"+e);
            e.printStackTrace();
            return "index.jsp";
        }
    }

    private void createLoggingTime(Users user) {
        if (user.getLogging_log() == null) {
            DaoFactory.getDao(DaoFactory.DaoNames.LOGGING_LOG)
                    .create(
                            Logging_log.builder().logDate(new Date())
                                    .idUser(user).id(0).build()
                    );

        } else {

            user.getLogging_log().setLogDate(new Date());
            DaoFactory.getDao(DaoFactory.DaoNames.LOGGING_LOG).update(user.getLogging_log());
        }
    }
}
