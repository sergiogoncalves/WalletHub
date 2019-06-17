package com.ef.parse.utils;

import com.ef.parse.model.LogDO;
import com.ef.parse.service.log.LogService;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    LogService logService;

    public Utils(LogService logService) {
        this.logService = logService;
    }

    public void readFile(String pathToFile) throws Exception{

        try (

             InputStream is = new FileInputStream(pathToFile);
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)

            ) {


            List<LogDO> logFile = new ArrayList<>();
            String row = br.readLine();

            while(row != null) {

                logFile.add(LogDO.logDOParse(row.split("\\|")));

                row = br.readLine();
            }


            logService.saveAll(logFile);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
