package com.ef.Parser.repository;

import com.ef.Parser.model.LogDO;
import com.ef.Parser.model.ResultDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogDO, Long> {



    @Query("SELECT new com.ef.Parser.model.ResultDO(L.ip, count(L)) " +
            "  from LogDO L " +
            "  where L.date between :initialDate and :finalDate" +
            "  group by L.ip " +
            " having count(L) > :threshold")
    List<ResultDO> getResults(@Param("initialDate") Date initialDate, @Param("finalDate") Date finalDate, @Param("threshold") Long threshold);
}
