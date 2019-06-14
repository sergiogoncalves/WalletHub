package com.ef.parse.utils;

import com.ef.parse.Service.Log.LogService;
import com.ef.parse.model.LogDO;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    LogService logService;

    public Utils(LogService logService) {
        this.logService = logService;
    }

    public void readFile(String pathToFile){

        try (

             InputStream is = new FileInputStream(pathToFile);
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)
            ) {

            String[] command;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

            List<LogDO> logFile = new ArrayList<>();
            String row = br.readLine();

            while(row != null) {

                command = row.split("\\|");

                LogDO logDO = new LogDO();

                logDO.setDate(LocalDateTime.parse(command[0], formatter));
                logDO.setIp(command[1]);
                logDO.setRequest(command[2]);
                logDO.setStatus(Integer.parseInt(command[3]));
                logDO.setUserAgent(command[4]);

                logFile.add(logDO);

                row = br.readLine();
            }

            logService.saveAll(logFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
