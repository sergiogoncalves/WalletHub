package com.ef.parse;

import com.ef.parse.utils.Parameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Parser {


    public static void main(String[] args) {

        try {

            for (String param : args) {

                param = param.replace("--", "");

                String[] p = param.split("=");

                Parameters.addParameterValue(p[0], p[1]);
            }

            Parameters.checkParameters();

            SpringApplication.run(Parser.class, args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
