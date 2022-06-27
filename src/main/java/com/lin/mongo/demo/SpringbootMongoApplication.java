package com.lin.mongo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

//@EnableMongoRepositories(basePackages = {"com.lin.mongo.demo.user.dao"})
public class SpringbootMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongoApplication.class, args);
    }

}
