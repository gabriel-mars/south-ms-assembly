package com.gabriel.martins.assembly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MsAssemblyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAssemblyApplication.class, args);
	}

}
