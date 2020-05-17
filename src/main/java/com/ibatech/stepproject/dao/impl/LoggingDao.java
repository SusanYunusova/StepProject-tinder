package com.ibatech.stepproject.dao.impl;
import com.ibatech.stepproject.dao.Dao;
import com.sun.javafx.binding.Logging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LoggingDao implements Dao<Logging> {
    @Override
    public Optional getById(int id) {
        return Optional.ofNullable(getEMCreator().getEntityManager().find(Logging.class,id));
    }

    @Override
    public Collection<Logging> getAllById(int id) {
        return new ArrayList<>();//todo galib
    }

    @Override
    public Collection<Logging> getAll() {
        return getEMCreator().getEntityManager().createNamedQuery("Logging_log.findAll",Logging.class).getResultList();
    }


    @Override
    public Collection<Logging> getAllBy(Predicate<Logging> p) {
        return getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void create(Logging data) {
        try {
            System.out.println("trying to creating logging ");
            getEMCreator().getEntityManager().persist(data);
            getEMCreator().openTransaction();

        }catch (Exception e){
            System.out.println("error creating logging "+e);
            getEMCreator().rollBack();
        }

    }

    @Override
    public boolean delete(int id) {
try {
    getEMCreator().getEntityManager().remove(id);
    return true;//todo galib
}catch (Exception e){
return false;
}
    }

    @Override
    public boolean update(Logging logging) {
        try {
            System.out.println("trying to update logging");
            getEMCreator().getEntityManager().persist(logging);
            return true;
        }catch (Exception e){
            getEMCreator().rollBack();
            return false;

        }
    }

}
