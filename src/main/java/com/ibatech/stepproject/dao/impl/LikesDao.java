package com.ibatech.stepproject.dao.impl;

import com.ibatech.stepproject.dao.Dao;
import com.ibatech.stepproject.entities.Likes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LikesDao implements Dao<Likes> {
    @Override
    public Optional<Likes> getById(int id) {
        return Optional.ofNullable(getEMCreator().getEntityManager().find(Likes.class, id));
    }

    @Override
    public Collection<Likes> getAllById(int id) {

        return new ArrayList<>();//todo bu qalib
    }

    @Override
    public Collection<Likes> getAll() {
        return getEMCreator().getEntityManager().createNamedQuery("Likes.findAll", Likes.class).getResultList();
    }

    @Override
    public Collection<Likes> getAllBy(Predicate<Likes> p) {
        return getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public Likes create(Likes data) {
        try {
            System.out.println("trying to creat likes..");
            getEMCreator().getEntityManager().persist(data);
            getEMCreator().openTransaction();
        } catch (Exception e) {//todo
            System.out.println("Error creating like " + e);
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
    public boolean update(Likes likes) {
        try {
            System.out.println("trying to update likes");
            getEMCreator().getEntityManager().persist(likes);
            getEMCreator().openTransaction();
            return true;
        } catch (Exception e) {
            getEMCreator().rollBack();
            return false;
        }

    }
}
