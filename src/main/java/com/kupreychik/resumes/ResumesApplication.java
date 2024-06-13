package com.kupreychik.resumes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class ResumesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumesApplication.class, args);
    }

}
