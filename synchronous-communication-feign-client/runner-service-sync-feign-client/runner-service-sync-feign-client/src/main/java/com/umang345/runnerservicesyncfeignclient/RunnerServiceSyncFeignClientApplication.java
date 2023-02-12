package com.umang345.runnerservicesyncfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RunnerServiceSyncFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerServiceSyncFeignClientApplication.class, args);
	}

}
