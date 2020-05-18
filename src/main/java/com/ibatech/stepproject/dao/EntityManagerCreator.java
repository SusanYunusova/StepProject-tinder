package com.ibatech.stepproject.dao;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Slf4j
public class EntityManagerCreator {
    private static EntityManagerCreator instance;
    private EntityManagerFactory emf;
    private EntityManager em;


    public static EntityManagerCreator getInstance() {
        if (instance == null) {
            instance = new EntityManagerCreator();
        }
        return instance;

    }

    public EntityManagerCreator() {
        log.info("emc constructor");
        try {
            emf = Persistence.createEntityManagerFactory("tinderPU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            System.out.println("Error persistence : {}" + e);
        }
        log.info("entity manager created");
    }
    public EntityManager getEntityManager(){
        System.out.println("getting em ");
        return em;
    }
    public  void close(){//todo try
        em.close();
        emf.close();
        instance=null;
    }
    public  void  openTransaction(){
        //todo logs
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    public  void rollBack(){
        em.getTransaction().rollback();
    }
}
