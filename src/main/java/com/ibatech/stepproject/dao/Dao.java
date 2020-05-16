package com.ibatech.stepproject.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface Dao<A> {
    Optional<A> getById(int id);
    Collection<A> getAllById(int id);
    Collection<A> getAll();
    Collection<A> getAllBy(Predicate<A> p);
    void create(A data);
    boolean delete(int id);
    boolean update(A a);
    default EntityManagerCreator getEMCreator(){
        return  EntityManagerCreator.getInstance();
    }


}
