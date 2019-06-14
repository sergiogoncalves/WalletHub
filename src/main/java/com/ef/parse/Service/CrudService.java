package com.ef.parse.Service;

import java.util.List;

public interface CrudService<T, ID> {

    void saveAll(List<T> object);
}

