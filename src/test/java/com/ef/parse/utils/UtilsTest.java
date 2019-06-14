package com.ef.parse.utils;

import com.ef.parse.Service.Log.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}