package com.ef.Parser.service.log;

import com.ef.Parser.model.LogDO;
import com.ef.Parser.model.ResultDO;
import com.ef.Parser.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface LogService extends CrudService<LogDO, Long> {

    List<ResultDO> getStatistics(Date initialDate, Date finalDate, Long threshold);

    void processFile(String path)throws Exception;

    void deleteAll();
}
