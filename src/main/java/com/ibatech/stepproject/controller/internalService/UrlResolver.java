package com.ibatech.stepproject.controller.internalService;


import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.dao.DaoFactory;
import com.ibatech.stepproject.dao.impl.UsersDao;
import com.ibatech.stepproject.entities.Likes;
import com.ibatech.stepproject.entities.Users;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
public class UrlResolver {

    private  HttpServletRequest request;
    private  HttpServletResponse response;

    public UrlResolver(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public String getUrl() {
        String uid  = request.getParameter("uid");
        System.out.println("uid : "+uid);
        switch(uid){
            case "login" : {
                return doLoginService();
            }
            case "register" : {
                return "register.jsp";
            }
            default:{
                return "index.jsp";
            }
        }
    }

    private String doLoginService(){
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Dao<Users> dao = DaoFactory.getDao(DaoFactory.DaoNames.USERS);

        Optional<Users> user = ((UsersDao) dao).getByEmailAndPassword(email, password);

        return user.map(usr -> "people-list.html").orElseGet(()->"index.jsp");

    }


}
