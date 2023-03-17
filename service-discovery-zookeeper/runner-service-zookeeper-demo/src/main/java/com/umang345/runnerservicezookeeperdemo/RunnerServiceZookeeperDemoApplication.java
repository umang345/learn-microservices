package com.umang345.runnerservicezookeeperdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RunnerServiceZookeeperDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerServiceZookeeperDemoApplication.class, args);
	}

}
