package com.plan.startup;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.plan.startup.Services.GaanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

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
