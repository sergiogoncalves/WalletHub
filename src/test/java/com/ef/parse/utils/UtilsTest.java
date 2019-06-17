package com.ef.parse.utils;

import com.ef.parse.service.log.LogService;
import com.ef.parse.model.ResultDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

        Utils util = new Utils(logService);

       // util.readFile("D:\\SergioProjects\\WalletHub\\requirements\\access.log");

        util.readFile("C:\\Users\\Sérgio Gonçalves\\Documents\\Projetos Spring Boot\\WalletHub\\requirements\\access.log");


    }

    @Test
    public void getStatistics() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime.parse("2017-01-01 15:00:00", formatter);

        List<ResultDO> resultado = logService.getStatistics(LocalDateTime.parse("2017-01-01 15:00:00", formatter), LocalDateTime.parse("2017-01-01 16:00:00", formatter), 2L);

        resultado.forEach(word -> {
            System.out.println(word.getIp());
        });
    }
}