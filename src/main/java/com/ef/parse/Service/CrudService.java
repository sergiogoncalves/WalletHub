package com.ef.parse.Service;

import java.util.Collection;
import java.util.List;

public interface CrudService<T, ID> {

    Collection<T> findAll();

    T findById(ID id);

    T save(T object);

    void saveAll(List<T> object);

    void delete(T object);

    void deleteById(ID id);

}

