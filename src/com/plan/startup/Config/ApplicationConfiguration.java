package com.plan.startup.Config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import io.druid.jackson.AggregatorsModule;
import io.druid.jackson.DruidDefaultSerializersModule;
import io.druid.jackson.QueryGranularityModule;
import io.druid.jackson.SegmentsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * Created by anirudh.b on 04/02/17.
 */
@Configuration
public class ApplicationConfiguration {
    @Bean(name = "jsonHeaders")
    public Map<String, String> getJsonHeaders(){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("content-type", "application/json");
        return headers;
    }

    @Bean(name = "objectMapper")
    public ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    @Bean
    public Queue<String> getQueue(){
        return new LinkedList<String>();
    }

    @Bean
    public ArrayList<String> getList(){
        return new ArrayList<>();
    }

}