package com.ibatech.stepproject.dao.impl;

import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.entities.Messages;
import com.ibatech.stepproject.entities.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MessagesDao implements Dao<Messages> {
    @Override
    public Optional<Messages> getById(int id) {
        return Optional.ofNullable(getEMCreator().getEntityManager().find(Messages.class, id));
    }


    @Override
    public Collection<Messages> getAllById(int id) {
        return new ArrayList<>();//todo qalib
    }

    @Override
    public Collection<Messages> getAll() {
        return getEMCreator().getEntityManager().createNamedQuery("Messages.findAll", Messages.class).getResultList();
    }


    @Override
    public Collection<Messages> getAllBy(Predicate<Messages> p) {
        return getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public Messages create(Messages data) {
        try {
            System.out.println("trying to create massages");
            getEMCreator().getEntityManager().persist(data);
            getEMCreator().openTransaction();
        } catch (Exception e) {
            System.out.println("Error creating messages " + e);
            getEMCreator().rollBack();
        }

        return null;
    }


    @Override
    public boolean delete(int id) {
        try {
            getEMCreator().getEntityManager().remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Messages messages) {
        try {
            System.out.println("try to update messages");
            getEMCreator().getEntityManager().persist(messages);
            getEMCreator().openTransaction();
            return true;
        } catch (Exception e) {
            getEMCreator().rollBack();
            return false;
        }
    }
    public List<Messages> getUserMessages(Users userFrom, Users userTo){
      return  getEMCreator()
                .getEntityManager()
                .createNamedQuery("Messages.findByFromTo",Messages.class)
                .setParameter("userFrom",userFrom)
                .setParameter("userTo",userTo)
                .getResultList();


    }
}
