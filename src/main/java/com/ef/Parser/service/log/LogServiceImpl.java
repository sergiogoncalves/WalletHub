package com.ef.Parser.service.log;


import com.ef.Parser.model.LogDO;
import com.ef.Parser.model.ResultDO;
import com.ef.Parser.repository.LogRepository;
import com.ef.Parser.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    LogRepository logRepository;
    Utils utils;


    public LogServiceImpl(LogRepository logRepository, Utils utils) {
        this.logRepository = logRepository;
        this.utils = utils;
    }

    @Override
    public void saveAll(List<LogDO> object) {
         logRepository.saveAll(object);
    }

    @Override
    public List<ResultDO> getStatistics(Date initialDate, Date finalDate, Long threshold) {
        return logRepository.getResults(initialDate, finalDate, threshold);
    }

    public void processFile(String pathToFile) throws Exception{
        saveAll(utils.readFile(pathToFile));
    }

    @Override
    public void deleteAll() {
        logRepository.deleteAll();
    }
}
