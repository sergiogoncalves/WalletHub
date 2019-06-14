package com.ef.parse.repository;

import com.ef.parse.model.LogDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogDO, Long> {
}
