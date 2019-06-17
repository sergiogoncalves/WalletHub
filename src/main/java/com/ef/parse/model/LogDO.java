package com.ef.parse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log")
public class LogDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String ip;

    private String request;

    private int status;

    @Column(name = "user_agent")
    private String userAgent;

    public static LogDO logDOParse(String[] log) throws Exception{

        String formatter = "yyyy-MM-dd HH:mm:ss.SSS";

        LogDO logDO = new LogDO();

        logDO.setDate(new SimpleDateFormat(formatter).parse(log[0]));
        logDO.setIp(log[1]);
        logDO.setRequest(log[2]);
        logDO.setStatus(Integer.parseInt(log[3]));
        logDO.setUserAgent(log[4]);

        return logDO;

    }
}


