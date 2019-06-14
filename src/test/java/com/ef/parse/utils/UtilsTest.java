package com.ef.parse.utils;

import com.ef.parse.Service.Log.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTest {

    @Autowired
    LogService logService;

    @Test
    public void readFile() {

        Utils util = new Utils(logService);

        util.readFile("D:\\SergioProjects\\WalletHub\\requirements\\access.log");
    }

    @Test
    public void getStatistics() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime.parse("2017-01-01 15:00:00", formatter);

        List<String> resultado = logService.getStatistics(LocalDateTime.parse("2017-01-01 15:00:00", formatter), LocalDateTime.parse("2017-01-01 16:00:00", formatter), 2L);

        resultado.forEach(word -> {
            System.out.println(word);
        });
    }
}