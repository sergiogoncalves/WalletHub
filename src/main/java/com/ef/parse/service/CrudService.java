package com.ef.parse.service;

import java.util.List;

public interface CrudService<T, ID> {

    void saveAll(List<T> object);
}

