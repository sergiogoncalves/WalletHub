package com.ef.parse.Service.Log;


import com.ef.parse.model.LogDO;
import com.ef.parse.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Collection<LogDO> findAll() {
        return null;
    }

    @Override
    public LogDO findById(Long aLong) {
        return null;
    }

    @Override
    public LogDO save(LogDO object) {
        return null;
    }

    @Override
    public void saveAll(List<LogDO> object) {

         logRepository.saveAll(object);

    }

    @Override
    public void delete(LogDO object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
