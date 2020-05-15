package com.ibatech.stepproject.controller.internalService;


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

    private  EntityManagerFactory emf;
    private  EntityManager em;


    public UrlResolver(HttpServletRequest request, HttpServletResponse response) {
        log.info("constructor");
        try {
            emf = Persistence.createEntityManagerFactory("tinderPU");
            em = emf.createEntityManager();
        }catch (Exception e){
            System.out.println("Error persistence : {}"+e);
        }
        log.info("entity manager created");
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
        try {
            em.persist(user);
            em.getTransaction().begin();
            em.getTransaction().commit();

            List<Likes> resultList = em.createNamedQuery("Likes.findAll", Likes.class).getResultList();
            resultList.forEach(likes -> {
                LocalDateTime date = likes.getDate();
                Users idUserFrom = likes.getIdUserFrom();

            });
        }catch (Exception e){
            System.out.println("Error saving : "+e);
        }
        return "index.jsp";
    }
}
