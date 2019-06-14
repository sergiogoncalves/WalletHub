package com.ef.parse.Service.Log;

import com.ef.parse.Service.CrudService;
import com.ef.parse.model.LogDO;
import org.springframework.stereotype.Service;

@Service
public interface LogService extends CrudService<LogDO, Long> {
}
