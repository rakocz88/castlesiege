package com.pilaf.cs.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersServer {

    public static void main(String[] args) {
    	
        SpringApplication.run(UsersServer.class, args);
    }
}