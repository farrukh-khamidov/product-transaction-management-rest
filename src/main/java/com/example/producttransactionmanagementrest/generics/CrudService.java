package com.example.producttransactionmanagementrest.generics;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudService<T, ID> {
    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    long count();

    void deleteById(ID id);

    void delete(T entity);

    void deleteAllById(Iterable<? extends ID> ids);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();

    CrudRepository<T, ID> getRepository();
}
