package com.ef.parse.Service.Log;


import com.ef.parse.model.LogDO;
import com.ef.parse.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }



    @Override
    public void saveAll(List<LogDO> object) {

         logRepository.saveAll(object);

    }

    @Override
    public List<String> getStatistics(LocalDateTime initialDate, LocalDateTime finalDate, Long threshold) {
        return logRepository.getResults(initialDate, finalDate, threshold);
    }
}
