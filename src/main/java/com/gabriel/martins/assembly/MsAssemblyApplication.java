package com.gabriel.martins.assembly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@EnableScheduling
@SpringBootApplication
public class MsAssemblyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAssemblyApplication.class, args);
	}

}
