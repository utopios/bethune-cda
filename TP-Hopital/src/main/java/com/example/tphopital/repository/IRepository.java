package com.example.tphopital.repository;

import java.util.List;

public interface IRepository<T> {
    boolean create(T element);
    boolean update(T element);
    boolean delete(T element);

    List<T> findAll();

    T findById();
}
