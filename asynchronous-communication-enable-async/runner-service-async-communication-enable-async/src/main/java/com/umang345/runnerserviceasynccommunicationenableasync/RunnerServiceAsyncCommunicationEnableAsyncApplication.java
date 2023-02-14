package com.umang345.runnerserviceasynccommunicationenableasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RunnerServiceAsyncCommunicationEnableAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerServiceAsyncCommunicationEnableAsyncApplication.class, args);
	}

}
