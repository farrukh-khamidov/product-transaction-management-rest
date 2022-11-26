package com.example.producttransactionmanagementrest.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public abstract class JpaServiceImpl<T, ID> extends CrudServiceImpl<T, ID> implements JpaService<T, ID>{

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public abstract JpaRepository<T, ID> getRepository();
}
