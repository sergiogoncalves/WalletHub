package com.ef.parse.utils;

import com.ef.parse.service.log.LogService;
import com.ef.parse.model.ResultDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTest {

    @Autowired
    LogService logService;

    @Test
    public void readFile() throws Exception {

     //   Utils util = new Utils(logService);

       // util.readFile("D:\\SergioProjects\\WalletHub\\requirements\\access.log");

       // util.readFile("C:\\Users\\Sérgio Gonçalves\\Documents\\Projetos Spring Boot\\WalletHub\\requirements\\access.log");


    }

    @Test
    public void getStatistics() {


    }
}