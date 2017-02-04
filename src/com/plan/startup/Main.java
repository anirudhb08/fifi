package com.plan.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by anirudh.b on 04/02/17.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}
