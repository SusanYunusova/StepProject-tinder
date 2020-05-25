package com.ibatech.stepproject.dao.impl;

import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.entities.Logging_log;
import com.sun.javafx.binding.Logging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LoggingDao implements Dao<Logging_log> {
    @Override
    public Optional getById(int id) {
        return Optional.ofNullable(getEMCreator().getEntityManager().find(Logging.class, id));
    }

    @Override
    public Collection<Logging_log> getAllById(int id) {
        return new ArrayList<>();//todo galib
    }

    @Override
    public Collection<Logging_log> getAll() {
        return getEMCreator().getEntityManager().createNamedQuery("Logging_log.findAll", Logging_log.class).getResultList();
    }


    @Override
    public Collection<Logging_log> getAllBy(Predicate<Logging_log> p) {
        return getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public Logging_log create(Logging_log data) {
        try {
            System.out.println("trying to creating Logging_log ");
            getEMCreator().getEntityManager().persist(data);
            getEMCreator().openTransaction();

        } catch (Exception e) {
            System.out.println("error creating Logging_log " + e);
            getEMCreator().rollBack();
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            getEMCreator().getEntityManager().remove(id);
            return true;//todo galib
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Logging_log logging) {
        try {
            System.out.println("trying to update logging");
            getEMCreator().getEntityManager().persist(logging);
            getEMCreator().openTransaction();

            return true;
        } catch (Exception e) {
            getEMCreator().rollBack();
            return false;

        }
    }

}
