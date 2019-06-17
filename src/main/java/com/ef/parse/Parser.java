package com.ef.parse;

import com.ef.parse.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Parser {

    public static void main(String[] args) {



        for (String param : args) {

            param = param.replace("--", "");

            String[] p = param.split("=");


        }


        SpringApplication.run(Parser.class, args);



    }




}
