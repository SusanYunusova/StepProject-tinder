package com.ibatech.stepproject.dao.impl;

import com.ibatech.stepproject.dao.Dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class LikesDao implements Dao {
    @Override
    public Optional getById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection getAllById(int id) {
        return null;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public Collection getAllBy(Predicate p) {
        return null;
    }

    @Override
    public void create(Object data) {

    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }
}
