package com.umang345.servicediscoveryeureka.runnerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RunnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerServiceApplication.class, args);
	}

}
