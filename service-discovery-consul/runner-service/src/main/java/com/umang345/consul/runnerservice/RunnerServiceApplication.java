package com.umang345.consul.runnerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RunnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerServiceApplication.class, args);
	}

}
