package com.ef.parse.Service.Log;

import com.ef.parse.Service.CrudService;
import com.ef.parse.model.LogDO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface LogService extends CrudService<LogDO, Long> {

    List<String> getStatistics(LocalDateTime initialDate, LocalDateTime finalDate, Long threshold);
}
