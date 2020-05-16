package com.ibatech.stepproject.dao.impl;

import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.dao.EntityManagerCreator;
import com.ibatech.stepproject.entities.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UsersDao implements Dao<Users> {

    @Override
    public Optional<Users> getById(int id) {
        return Optional.ofNullable(getEMCreator().getEntityManager().find(Users.class,id));
    }

    @Override
    public Collection<Users> getAllById(int id) {
        return new ArrayList<>();//todo bu qalib
    }

    @Override
    public Collection<Users> getAll() {
        return getEMCreator().getEntityManager().createNamedQuery("Users.findAll",Users.class).getResultList();
    }

    @Override
    public Collection<Users> getAllBy(Predicate<Users> p) {
        return  getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void create(Users data) {
        try {
            System.out.println("trying to create user");
        getEMCreator().getEntityManager().persist(data);
        getEMCreator().openTransaction();

        }catch (Exception e){//todo logs
            System.out.println("error creting user.."+e);
            getEMCreator().rollBack();
        }
    }

    @Override
    public boolean delete(int id) { //todo logs
        try {
        getEMCreator().getEntityManager().remove(id);
          return true;
        }catch (Exception e){
            return  false;
        }

    }

    @Override
    public boolean update(Users users) {
        try {
            System.out.println("trying to update user");
            getEMCreator().getEntityManager().persist(users);
            getEMCreator().openTransaction();
        }catch ()
        return false;
    }
}