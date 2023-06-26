package com.ayrtonmonier.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

    @Autowired
    private CsvDataLoaderRunner csvDataLoaderRunner;

    @Autowired
    private JsonDataLoaderRunner jsonDataLoaderRunner;

    
    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initDataLoaderCSV();
        initDataLoaderJSON();
    }

    public void initDataLoaderCSV() {
        csvDataLoaderRunner.loadDataFromCSV();
    }
    
    public void initDataLoaderJSON() {
        jsonDataLoaderRunner.loadDataFromJSON();
    }
    
}
