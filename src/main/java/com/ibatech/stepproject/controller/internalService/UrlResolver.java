package com.ibatech.stepproject.controller.internalService;


import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.dao.DaoFactory;
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

@Slf4j
public class UrlResolver {

    public UrlResolver(HttpServletRequest request, HttpServletResponse response) {

    }

    public String getUrl() {
        Users user = Users
                .builder()
                .email("test@test.com")
                .age(13)
                .name("test")
                .password("test")
                .surname("testov")
                .id(0)
                .build();

        System.out.println("User : "+user.toString());
        Dao<Users> dao = DaoFactory.getDao(DaoFactory.DaoNames.USERS);
        dao.create(user);
        return "index.jsp";
    }
}
