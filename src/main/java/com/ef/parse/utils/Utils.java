package com.ef.parse.utils;

import com.ef.parse.model.LogDO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Utils {

    public static final String DAILY = "daily";
    public static final String HOURLY = "hourly";


    public List<LogDO> readFile(String pathToFile) throws Exception{

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

            return logFile;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date getFinalDate(Date startDate, String duration) {

        try {

            Long resultDateInLong = 0l;

            if (duration.equals(DAILY)) {
                resultDateInLong = startDate.getTime() + (24 * 60 * 60 * 1000);
            } else if (duration.equals(HOURLY)) {
                resultDateInLong = startDate.getTime() + (60 * 60 * 1000);
            }

            return new Date(resultDateInLong);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
