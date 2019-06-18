package com.ef.Parser.service;

import java.util.List;

public interface CrudService<T, ID> {

    void saveAll(List<T> object);

    void deleteAll();
}

