package com.ef.parse.repository;

import com.ef.parse.model.LogDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogDO, Long> {



    @Query("SELECT L.ip " +
            "  from LogDO L " +
            "  where L.date between :initialDate and :finalDate" +
            "  group by L.ip " +
            " having count(L) > :threshold")
    List<String> getResults(@Param("initialDate") LocalDateTime initialDate, @Param("finalDate") LocalDateTime finalDate, @Param("threshold") Long threshold);
}
