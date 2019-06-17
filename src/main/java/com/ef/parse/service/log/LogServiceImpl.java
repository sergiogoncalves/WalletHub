package com.ef.parse.service.log;


import com.ef.parse.model.LogDO;
import com.ef.parse.model.ResultDO;
import com.ef.parse.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
    public List<ResultDO> getStatistics(LocalDateTime initialDate, LocalDateTime finalDate, Long threshold) {
        return logRepository.getResults(initialDate, finalDate, threshold);
    }

    public void processFile(String pathToFile) throws Exception{

        try (

                InputStream is = new FileInputStream(pathToFile);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr)
        ) {

            String[] command;

            String formatter = "yyyy-MM-dd HH:mm:ss.SSS";

            List<LogDO> logFile = new ArrayList<>();
            String row = br.readLine();

            while(row != null) {

                logFile.add(LogDO.logDOParse(row.split("\\|")));

                row = br.readLine();

            }

            saveAll(logFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
