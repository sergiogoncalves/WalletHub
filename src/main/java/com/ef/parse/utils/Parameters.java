package com.ef.parse.utils;

import com.ef.parse.exception.MissingParameterException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class Parameters {

    public static String accesslog;
    public static Date startDate;
    public static String duration;
    public static Long threshold;

    public static void checkParameters() throws MissingParameterException {
        if (accesslog == null
                ||  startDate == null
                ||  duration  == null
                ||  threshold == null)
            throw new MissingParameterException();
    }

    public static void addParameterValue(String param, String value) throws MissingParameterException, ParseException {
        switch (param) {
            case "accesslog":
                setAccesslog(value);
                break;
            case "startDate":
                setStartDate(value);
                break;
            case "duration":
                setDuration(value);
                break;
            case "threshold":
                setThreshold(Long.parseLong(value));
                break;

            default:
                throw new MissingParameterException(param);
        }
    }

    public static void setAccesslog(String accesslog) {
        Parameters.accesslog = accesslog;
    }

    public static void setStartDate(String startDate) throws ParseException {
        Parameters.startDate =  new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss").parse(startDate);
    }

    public static void setDuration(String duration) {
        Parameters.duration = duration;
    }

    public static void setThreshold(Long threshold) {
        Parameters.threshold = threshold;
    }
}
