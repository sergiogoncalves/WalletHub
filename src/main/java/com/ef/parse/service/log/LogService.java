package com.ef.parse.service.log;

import com.ef.parse.service.CrudService;
import com.ef.parse.model.LogDO;
import com.ef.parse.model.ResultDO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface LogService extends CrudService<LogDO, Long> {

    List<ResultDO> getStatistics(LocalDateTime initialDate, LocalDateTime finalDate, Long threshold);

    void processFile(String path)throws Exception;
}